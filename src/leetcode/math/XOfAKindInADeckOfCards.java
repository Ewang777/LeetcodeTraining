package leetcode.math;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/27
 */
public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        int[] map = new int[10000];
        for (int i : deck) {
            map[i]++;
        }
        int greatestCommonDivisor = 0;
        for (int value : map) {
            if (value == 0) {
                continue;
            }
            greatestCommonDivisor = getGreatestCommonDivisor(greatestCommonDivisor, value);
            if (greatestCommonDivisor < 2) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param num1 more than zero or equals zero
     * @param num2 more than zero
     * @return the greatest common divisor of num1 and num2
     */
    private static int getGreatestCommonDivisor(int num1, int num2) {
        int mod;
        while ((mod = num1 % num2) != 0) {
            num1 = num2;
            num2 = mod;
        }
        return num2;
    }
}
