package leetcode;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/16
 */
public class CompressStringLcci {
    public static void main(String[] args) {
        String str = "aa";
        System.out.println(compressString(str));
    }

    public static String compressString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        char preChar = S.charAt(0);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (preChar == c) {
                count++;
            } else {
                stringBuilder.append(preChar).append(count);
                preChar = c;
                count = 1;
            }
        }
        String result = stringBuilder.append(preChar).append(count).toString();
        return S.length() <= result.length() ? S : result;
    }
}
