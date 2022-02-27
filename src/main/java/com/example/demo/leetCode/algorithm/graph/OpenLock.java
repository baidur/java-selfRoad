package com.example.demo.leetCode.algorithm.graph;

import java.util.*;

/**
 * 文件描述：解开密码锁的最小次数
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ECCG
 * @Package: com.example.demo.leetCode.algorithm.graph
 * @Description: note
 * @Author: chenxy43169
 * @CreateDate: 2022/2/22 10:59
 * @UpdateUser: chenxy43169
 * @UpdateDate: 2022/2/22 10:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright  2022 Hundsun Technologies Inc. All Rights Reserved
 **/
public class OpenLock {

    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        int depth = openLock(deadends, "8888");
        System.out.println(depth);
    }

    public static int openLock(String[] deadends, String target){
        List<String> list = Arrays.asList(deadends);
        int depth = 0;
        Queue<String> queue = new LinkedList<>();
        List<String> lists = new ArrayList<>();
        queue.offer("0000");
        lists.add("0000");
        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0;i < sz;i++){
                String str = queue.poll();
                if (list.contains(str) || lists.contains(str)){
                    continue;
                }
                if (str.equals(target)){
                    return depth;
                }
                for(int j = 0;j < str.length();j++){
                    String a = transform(str, j, true);
                    String b = transform(str, j, false);
                    lists.add(a);
                    lists.add(b);
                    queue.offer(a);
                    queue.offer(b);
                }
            }
            depth ++;
        }
        return -1;
    }

    public static String transform(String str, int index, boolean flag){
        StringBuilder sb = new StringBuilder(str);
        int t = Integer.parseInt(str.substring(index, index + 1));
        if (flag){
            t = t - 1;
            if (t < 0){
                t = 9;
            }
        }else {
            t = t + 1;
            if (t > 9){
                t = 0;
            }
        }
        sb.replace(index, index + 1, Integer.toString(t));
        return sb.toString();
    }
}
