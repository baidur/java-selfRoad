package com.example.demo.leetCode.algorithm;

import java.util.Arrays;

/**
 * 凑零钱问题
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 *
 * 输入: coins = [5, 5, 1], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * 说明:
 * 动态规化本质是穷举
 * 三要素:
 * 1.重叠子问题：备忘录或者dp Table
 * 2.状态转移格式:明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case
 * 3.最优子结构
 *
 * 状态转移公式
 * F(0) = 0;
 * F(1) = min(F(1 - 1) + F(1 - 2) + F(1 - 5) + 1 ) = 1
 *
 * 图解:
 *                 11
 *               / |  \
 *             6   6   10
 *           / | \
 *          1  1  5
 *        / | \
 *      -4 -4  0
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return dp(coins,amount,memo);
    }

    public static int coinChange1(int[] coins, int amount) {
        return dp1(coins,amount);
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    static int dp1(int[] coins,int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0,j = coins.length ;i < j;i++){
            int ret = dp1(coins,amount - coins[i]);
            if(ret == -1){
                continue;
            }
            res = Math.min(res,ret + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    /**
     * 递归加备忘录：时间复杂度n(kO) = 子问题的个数n(O) * 子问题的时间n(k)
     * @param coins
     * @param amount
     * @param memo
     * @return
     */
    static int dp(int[] coins,int amount,int[] memo){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != 0){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0,j = coins.length ;i < j;i++){
            int ret = dp(coins,amount - coins[i],memo);
            if(ret == -1){
                continue;
            }
            res = Math.min(res,ret + 1);
            memo[amount] = res;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * dp 数组的迭代解法
     * @param amount
     * @param coins
     * @return
     */
    static int coinChange(int amount,int[] coins){
        //当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {5,5,1};
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange(amount, coins));
    }
}
