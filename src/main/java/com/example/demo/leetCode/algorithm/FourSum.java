package com.example.demo.leetCode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例:
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(Integer[] nums, int target) {
        System.out.println("aa");
        List<List<Integer>> all = new ArrayList<>(10);
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(nums));
        int right = 4,sum = 0;
        if(nums.length < 4){
            for(int i = 0;i < nums.length;i++){
                sum = sum + nums[i];
            }
            if(sum == target){
                all.add(list);
            }
        }
        list.add(nums[0]);
        list.add(nums[1]);
        list.add(nums[2]);
        for(int i = 0;i < list.size() - 3; i++){
            List<Integer> item = list.subList(i,right);
            sum = item .stream().mapToInt(Integer::intValue).sum();
            if(sum == target){
                all.add(item);
            }
            right++;
        }

        return all;
    }


    public static void main(String[] args) {
        Integer[] nums = {1, 0, -1, 0, -2, 2};
        fourSum(nums,0);
    }
}
