package com.example.demo.jvm;

/**
 * 标记为垃圾之后，会尝试一次自救finalize,如果重新复制则不会被回收，如果第二次在出现GC，则不会在执行finalize
 */
public class FinalizeTestGC {

    private static FinalizeTestGC testGC = new FinalizeTestGC();

    public static void main(String[] args) throws InterruptedException {
        testGC = null;
        System.gc();
        Thread.sleep(2000);
        testGC.test();
        testGC = null;
        System.gc();
    }

    private void test(){
        System.out.println("成功跳脱GC");
    }

    @Override
    protected void finalize(){
        System.out.println("开始自救");
        testGC = this;
        System.out.println("开始结束");
    }
}
