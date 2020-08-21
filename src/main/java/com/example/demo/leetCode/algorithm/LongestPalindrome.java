package com.example.demo.leetCode.algorithm;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * F(1) = 1
 * F(2) = F(1) + F(2)
 * F(n) = F(1) = F(n - 1)
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        for(char c : ss){
            for(int i = 0;i < ss.length;i++){

            }
        }
        return s;
    }
}
