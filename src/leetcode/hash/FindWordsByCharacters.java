package leetcode.hash;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/17
 */
public class FindWordsByCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] alphabet = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            alphabet[chars.charAt(i) - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            boolean hit = true;
            int[] charMap = new int[26];
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                charMap[index]++;
                if (charMap[index] > alphabet[index]) {
                    hit = false;
                    break;
                }
            }
            if (hit) {
                count += word.length();
            }
        }
        return count;
    }

    private int countByTravel(String[] words, String chars) {
        int count = 0;
        for (String word : words) {
            String remainChars = chars;
            boolean hit = true;
            for (int i = 0; i < word.length(); i++) {
                int index = remainChars.indexOf(word.charAt(i));
                if (index < 0) {
                    hit = false;
                    break;
                } else {
                    remainChars = remainChars.substring(0, index) + remainChars.substring(index + 1);
                }
            }
            if (hit) {
                count += word.length();
            }
        }
        return count;
    }
}
