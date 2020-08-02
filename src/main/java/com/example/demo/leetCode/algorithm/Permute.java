package com.example.demo.leetCode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute {

    public static void backtrack(int n,
                                 ArrayList<Integer> output,
                                 List<List<Integer>> res,
                                 int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void backtrack1(ArrayList<Integer> output, List<List<Integer>> res, ArrayList<Integer> tempList) {
        // 所有数都填完了
        if (output.size() == tempList.size()) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < output.size(); i++) {
            if (tempList.contains(output.get(i))) {
                continue;
            }

            tempList.add(output.get(i));
            // 继续递归填下一个数
            backtrack1(output, res, tempList);
            System.out.println("tempList回溯之后的内容:" + tempList + "-------" + "i的值:" + i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void backtrack2(boolean[] output,Integer depth,int len, List<List<Integer>> res,int[] nums, ArrayList<Integer> tempList) {
        // 所有数都填完了
        if (depth == len) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (output[i]) {
                continue;
            }
            tempList.add(nums[i]);
            output[i] = true;
            // 继续递归填下一个数
            backtrack2(output, depth + 1, len, res,nums, tempList);
            System.out.println("tempList回溯之后的内容:" + tempList + "-------" + "i的值:" + i);
            tempList.remove(tempList.size() - 1);
            output[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        backtrack1(output, res, new ArrayList<>());
        return res;
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        boolean[] output = new boolean[nums.length];
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        backtrack2(output, 0, nums.length, res,nums, tempList);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        permute1(nums);
        permute2(nums);
    }

}
