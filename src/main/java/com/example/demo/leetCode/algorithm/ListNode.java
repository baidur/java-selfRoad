package com.example.demo.leetCode.algorithm;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

//    private ListNode next;
//    private Integer item;
//    private ListNode first;
//    private ListNode last;
//
//    public ListNode() {
//    }
//
//    public ListNode(ListNode next, Integer item) {
//        this.next = next;
//        this.item = item;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//
//    public Integer getItem() {
//        return item;
//    }
//
//    public void setItem(Integer item) {
//        ListNode l = last;
//        ListNode node = new ListNode(null,item);
//        last = node;
//        if(null == l){
//            first = node;
//        }else {
//            l.next = node;
//        }
//    }
//
//    public ListNode getFirst() {
//        return first;
//    }
//
//    public void setFirst(ListNode first) {
//        this.first = first;
//    }


}
