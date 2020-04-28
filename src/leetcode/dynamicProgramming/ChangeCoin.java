package leetcode.dynamicProgramming;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/23
 */
public class ChangeCoin {
    public static void main(String[] args) {
        //     0    5    10    15
        //1 :  1    1    1     1
        //5 :  1    2    3     4
        //10:  1    2    4     6
        //25:  1    2    4     6
        // dp[i][j] = d[i-1][j] + d[i][j-coin]
        System.out.println(compressArray(15));
    }

    public static int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[coins.length][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                int beforeMod = dp[i][j];
                if (j >= coins[i]) {
                    beforeMod += dp[i][j - coins[i]];
                }
                if (i != 0) {
                    beforeMod += dp[i - 1][j];
                }
                dp[i][j] = beforeMod % mod;
            }
        }
        return dp[coins.length - 1][n];
    }

    private static int compressArray(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = {25, 10, 5, 1};
        for (int coin : coins) {
            for (int i = coin; i < n + 1; i += coin) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        return dp[n];
    }
}
