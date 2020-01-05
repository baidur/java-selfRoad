package com.example.demo.thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 首先，如果运行的线程数小于核心线程数，直接创建一个新的核心线程来运行新的任务。
 *
 * 其次，如果运行的线程数达到了核心线程数，则把新任务入队列。
 *
 * 然后，如果队列也满了，则创建新的非核心线程来运行新的任务。
 *
 * 最后，如果非核心线程数也达到最大了，那就执行拒绝策略。
 */
public class MyThreadPoolExecutor implements Executor {

    /**
     * 最大线程数
     */
    private Integer maxSize;

    /**
     * 核心线程数
     */
    private Integer coreSize;

    /**
     * 队列
     */
    private BlockingQueue<Runnable> queue;

    /**
     * 线程池名称
     */
    private String name;

    /**
     * 解决策略
     */
    private final static RejectedExecutionHandler discardPolicy = new ThreadPoolExecutor.DiscardPolicy();

    /**
     * 正在运行的数量
     */
    private AtomicInteger runningCount = new AtomicInteger(0);

    public MyThreadPoolExecutor() {
    }

    public MyThreadPoolExecutor(Integer maxSize, Integer coreSize, BlockingQueue<Runnable> queue, String name) {
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.queue = queue;
        this.name = name;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(Integer coreSize) {
        this.coreSize = coreSize;
    }

    public BlockingQueue<Runnable> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(Runnable task) {

        //正在运行的线程数
        int count = runningCount.get();
        //如果正在运行的线程数小于核心线程数，则直接加入线程
        if(count <= coreSize){
            //注意，这里不一定增加成功，
            if(addWork(task,true)){
                return;
            }
        }
        //如果达到了核心线程数，这加入队列，先判断队列是否满了
        if(queue.offer(task)){

        }else {
            //如果入队失败，则走解决策略
//            if(!addWork(task,false)){
//                discardPolicy.rejectedExecution(task,this);
//            }
        }
    }

    private Runnable getTask(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
// 当前线程都要结束了，理应要把runningCount的数量减一
            runningCount.getAndDecrement();
            return null;
        }
    }

    /**
     * 首先，创建线程的依据是正在运行的线程数量有没有达到核心线程数或者最大线程数，所以我们还需要一个变量runningCount用来记录正在运行的线程数。
     *
     * 其次，这个变量runningCount需要在并发环境下加加减减，所以这里需要使用到Unsafe的CAS指令来控制其值的修改，用了CAS就要给这个变量加上volatile修饰，为了方便我们这里直接使用AtomicInteger来作为这个变量的类型。
     *
     * 然后，因为是并发环境中，所以需要判断runningCount < coreSize(或maxSize)（条件一）的同时修改runningCount CAS加一（条件二）成功了才表示可以增加一个线程，如果条件一失败则表示不能再增加线程了直接返回false，如果条件二失败则表示其它线程先修改了runningCount的值，则重试。
     *
     * 最后，创建一个线程并运行新任务，且不断从队列中拿任务来运行
     * @param newTask
     * @param core
     * @return
     */
    private boolean addWork(Runnable newTask,boolean core){
        //自旋判断是否可以真的创建一个线程
        for(;;){
            int count = runningCount.get();
            int max = core ? coreSize : maxSize;
            //不满足创建条件直接返回
            if(count >= max){
                return false;
            }

            if(runningCount.compareAndSet(count,count + 1)){
                String threadName = (core ? "core_" : "") + name;
                new Thread(() -> {
                    System.out.println("thread name: " + Thread.currentThread().getName());
                    Runnable task = newTask;
                    while (task != null || (task = getTask()) != null){
                        try {
                            task.run();
                        }finally {
                            task = null;
                        }
                    }
                },threadName).start();
                break;
            }
        }
        return true;
    }
}
