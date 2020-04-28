package leetcode.trie;

import java.util.Arrays;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/28
 */
public class ShortEncodingOfWord {
    private static class TrieNode {
        char val;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
        }
    }

    private static TrieNode root = new TrieNode('R');

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    public static int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        int length = 0;
        for (String word : words) {
            if (insert(word)) {
                length += word.length() + 1;
            }
        }
        return length;
    }


    private static boolean insert(String word) {
        TrieNode current = root;
        boolean success = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                success = true;
                current.children[index] = new TrieNode(word.charAt(i));
            }
            current = current.children[index];
        }
        return success;
    }


}
