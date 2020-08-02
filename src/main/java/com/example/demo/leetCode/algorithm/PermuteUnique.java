package com.example.demo.leetCode.algorithm;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 思路：在一定会产生重复结果集的地方剪枝
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class PermuteUnique {


    public static void backtrack(boolean[] output, Integer depth, int len, List<List<Integer>> res, int[] nums, Deque<Integer> stack) {
        // 所有数都填完了
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (output[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !output[i - 1]) {
                continue;
            }
            stack.addLast(nums[i]);
            output[i] = true;
            // 继续递归填下一个数
            backtrack(output, depth + 1, len, res,nums, stack);
            System.out.println("tempList回溯之后的内容:" + stack + "-------" + "i的值:" + i);
            stack.removeLast();
            output[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        boolean[] output = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        backtrack(output, 0, nums.length, res,nums, stack);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        permute(nums);
    }
}


