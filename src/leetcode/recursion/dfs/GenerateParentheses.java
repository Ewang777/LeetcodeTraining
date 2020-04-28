package leetcode.recursion.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/9
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private static List<String> result;

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(n, n, "");
        return result;
    }

    private static void dfs(int left, int right, String string) {
        if (left == 0 && right == 0) {
            result.add(string);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, string + "(");
        }
        if (right > left) {
            dfs(left, right - 1, string + ")");
        }
    }
}
