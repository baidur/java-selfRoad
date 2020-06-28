package com.example.demo.list;

import cn.hutool.crypto.SecureUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        SecureUtil.md5();
        Node node1 = new Node(null,1,null);
        Node node2 = new Node(node1,2,null);
        node1.setNext(node2);
        Node node3 = new Node(node2,3,null);
        node2.setNext(node3);
        System.out.println(node3.toString());
    }
//    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.size();
//        long aa = System.currentTimeMillis();
//        for(int i=0;i<1000000;i++){
//            list.add(i);
//        }
//        long bb = System.currentTimeMillis();
//        System.out.println(bb-aa);
//       Iterator<Integer> it=list.iterator();
//        while(it.hasNext())//判断是是否有下一项元素
//            {
//             System.out.println(it.next());//如果有下一项元素，则next（）获取到，打印出来
//            }
//            long cc = System.currentTimeMillis();
//            System.out.println(cc-bb);
//    }

}
