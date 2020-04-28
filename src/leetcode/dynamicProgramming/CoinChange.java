package leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/25
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        return fromTopToBottom(coins, amount);
    }

    private static int fromTopToBottom(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private static int fromBottomToTop(int[] coins, int amount) {
        int[] count = new int[amount];
        return getMinCoinChange(coins, amount, count);
    }

    private static int getMinCoinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int minResult = Integer.MAX_VALUE;
        for (int coin : coins) {
            int localBest = getMinCoinChange(coins, amount - coin, count);
            if (localBest < 0) {
                continue;
            }
            minResult = Math.min(localBest + 1, minResult);
        }
        count[amount - 1] = minResult == Integer.MAX_VALUE ? -1 : minResult;
        return count[amount - 1];
    }
}
