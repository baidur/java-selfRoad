package com.example.demo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 时间复杂度：O(nlogn)
 * 空间复杂度：快速排序使用递归，递归使用栈，因此它的空间复杂度为O(logn)
 * 稳定性：快速排序无法保证相等的元素的相对位置不变，因此它是不稳定的排序算法
 */
public class QuickSortTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = new int[1000000];
        for(int i = 0;i < 1000000;i++){
            arr[i] = new Random().nextInt(100);
        }
        testSort(arr,0,arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
      //  Arrays.stream(arr).forEach((System.out::println));
    }

    public static void sort(int[] array, int left, int right){
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    /**
     *        1、判断参数条件，其实这是递归的出口；
     *
     *        2、以数组的第一个元素为哨兵元素，让其他元素和它比较大小；(记住这时候第一个元素位置是口的，因为里面的值被作为哨兵元素保存起来了)
     *
     *         3、开始从数组尾部往前循环得到一个小于哨兵元素的  元素A ，把该  元素A  放到第一个元素位置（也就是哨兵元素位置上，因为哨兵元素位置是空的）；（这时候要记住 元素A  的位置是空的了）
     *
     *        4、开始从数组头部往后循环得到一个大于哨兵元素的   元素B ，把该  元素B  放在上一步中移出的  元素A  的位置上；
     *
     *        5、依次循环上面3、4步，直到最后一个元素为止，那么最后一个元素就存放哨兵元素了。
     *
     *        6、把小于哨兵元素的那一部分和大于哨兵元素的那一部分分别递归调用本函数，依次递归排序好所有元素；
     * @param array
     * @param left
     * @param right
     */
    public static void testSort(int[] array, int left, int right){
        if(left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int X = array[left];
        while (i < j){
            while (X < array[j] && i < j){
                j--;
            }
            array[i] = array[j];
            while (X >= array[i] && i < j){
                i++;
            }
            array[j] = array[i];
        }
        array[i] = X;
        testSort(array, left, i - 1);
        testSort(array,i + 1, right);
    }
}
