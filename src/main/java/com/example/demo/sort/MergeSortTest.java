package com.example.demo.sort;

import java.util.Arrays;

/**
 * 归并排序是一种概念上最简单的排序算法，与快速排序一样，归并排序也是基于分治法的。归并排序将待排序的元素序列分成两个长度相等的子序列，
 * 为每一个子序列排序，然后再将他们合并成一个子序列。合并两个子序列的过程也就是两路归并。
 * 归并排序是一种稳定的排序算法，归并排序的主要问题在于它需要一个与待排序数组一样大的辅助数组空间。
 * 由于归并排序每次划分时两个子序列的长度基本一样，所以归并排序最好、最差和平均时间复杂度都是nlog2n。
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] arr = {5,3,1,7,8,2,6,6,9};
        sort(arr,0,arr.length - 1);
        Arrays.stream(arr).forEach((System.out::println));
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];//辅助数组
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }

        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            a[i]=tmp[i];
    }

    public static void sort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            sort(a, start, mid);//对左侧子序列进行递归排序
            sort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

}
