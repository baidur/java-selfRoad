package com.example.demo.leetCode.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 示例 1:
 输入: [1,2,1]
 输出: [2,-1,2]
 解释: 第一个 1 的下一个更大的数是 2；
 数字 2 找不到下一个更大的数；
 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 解题思路：用单调栈：单调栈实际上就是栈，只是利用了一些巧妙的逻辑，使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）
 */
public class NextGreaterElements {

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length]; // 存放答案的数组
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = nums.length - 1; i >= 0; i--){
            s.push(nums[i]);
        }
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.getFirst() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = s.isEmpty() ? -1 : s.getFirst();
            //
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 我们可以不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果
     * 例子：
     * int[] arr = {1,2,3,4,5};
     * int n = arr.length, index = 0;
     * while (true) {
     *     print(arr[index % n]);
     *     index++;
     * }
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len]; // 存放答案的数组
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = len * 2 -1;i >= 0; i--){
            while (!s.isEmpty() && s.getFirst() <= nums[i % len]){
                s.pop();
            }

            res[i % len] = !s.isEmpty() ? s.getFirst() : -1;
            s.push(nums[i % len]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        nextGreaterElements(nums);
        nextGreaterElements1(nums);
    }
}
