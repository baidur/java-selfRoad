package com.example.demo.leetCode.algorithm;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {
        char[] items = s.toCharArray();
        String s1 ;
        int start = 0,end = 0,max = 0,length = items.length ;
        while (length > 0){
            for(int i = end; i < items.length; i++){
                end = i;
                s1 = s.substring(start,end);
                if(s1.contains(String.valueOf(items[i]))){
                    start ++;
                    break;
                }
            }
            max = max < (end - start + 1) ? end - start + 1 : max;
            length --;
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] items = s.toCharArray();
        int max = 0;
        int flag = 0;
        StringBuilder s1 = new StringBuilder();
        for(int i = 0; i < items.length; i++){
            String item = String.valueOf(items[i]);
            if(s1.toString().contains(item)){
                max = max < flag ? flag : max;
                String[] array = s1.toString().split(item);
                String s2 = array.length <= 1 ? item : array[1] + items[i];
                s1 = new StringBuilder(s2);
                flag = s1.length();
            }else {
                flag ++;
                s1.append(items[i]);
            }
        }

        max = max < flag ? flag : max;

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}
