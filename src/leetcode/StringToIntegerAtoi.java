package leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/3
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String str = "+1";
        System.out.println(myAtoi(str));

    }

    public static int myAtoi(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            return 0;
        }
        int total = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return negative ? -total : total;
    }
}
