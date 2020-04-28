package leetcode.palindrome;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome/
 *
 * @author shiyuan.tian
 * @date 2020/3/19
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int[] alphabet = new int[123];
        int total = 0;
        for (char c : s.toCharArray()) {
            alphabet[c]++;
        }
        for (int count : alphabet) {
            total += count / 2 * 2;
        }
        return total < s.length() ? total + 1 : total;
    }
}
