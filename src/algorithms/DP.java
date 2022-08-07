package algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class DP {
    public int solve(int num) {
        if (num == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if (num >= 1)
            min = Math.min(solve(num - 1) + 1, min);
        if (num >= 5)
            min = Math.min(solve(num - 5) + 1, min);
        if (num >= 11)
            min = Math.min(solve(num - 11) + 1, min);
        return min;
    }

    public int coinChange(int[] coins, int amount) {
        // 初始化备忘录,用amount+1填满备忘录,amount+1 表示该值不可以用硬币凑出来
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // 设置初始条件为 0
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // 根据动态转移方程求出最小值
//                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
            }
        }
        // 如果 `dp[amount] === amount+1`说明没有最优解返回-1,否则返回最优解
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int makeChange(int amount) {
        if (amount <= 0) return 0;

        // 校验是否已经在备忘录中存在结果,如果存在返回即可
        if (cache.get(amount) != null) return cache.get(amount);

        int min = Integer.MAX_VALUE;
        if (amount >= 1) {
            min = Math.min(makeChange(amount - 1) + 1, min);
        }

        if (amount >= 5) {
            min = Math.min(makeChange(amount - 5) + 1, min);
        }

        if (amount >= 11) {
            min = Math.min(makeChange(amount - 11) + 1, min);
        }

        cache.put(amount, min);
        return min;

    }

}
