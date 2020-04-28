package leetcode.palindrome;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome/
 *
 * @author shiyuan.tian
 * @date 2020/3/19
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        // aaccaaa
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }

    public static String shortestPalindrome(String s) {
        return doublePoint(s);
    }

    private static String reverseCompare(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (reverse.substring(s.length() - i).equals(s.substring(0, i))) {
                sb.append(reverse, 0, s.length() - i);
                break;
            }
        }
        sb.append(s);
        return sb.toString();
    }

    private static String doublePoint(String s) {
        int i = 0;
        for (int n = s.length() - 1; n >= 0; n--) {
            if (s.charAt(i) == s.charAt(n)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        String suffix = s.substring(i);
        return new StringBuilder(suffix).reverse() + doublePoint(s.substring(0, i)) + suffix;
    }

}
