package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/10
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = reverseWords("a good   example");
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    private static String useStack(String s) {
        Stack<String> stack = new Stack<>();
        for (String word : s.trim().split(" +")) {
            stack.push(word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            if (!stack.isEmpty()) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }
}
