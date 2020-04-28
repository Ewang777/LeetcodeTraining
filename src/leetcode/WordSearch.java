package leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/28
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A' , 'B' , 'C' , 'E'},
                {'S' , 'F' , 'E' , 'S'},
                {'A' , 'D' , 'E' , 'E'}
        };
        String word = "ASFDD";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        if (board.length * board[0].length < wordArr.length) {
            return false;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0]) {
                    if (search(board, flag, i, j, wordArr, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, boolean[][] flag, int i, int j, char[] word, int charIndex) {
        if (charIndex == word.length) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }
        if (board[i][j] != word[charIndex]) {
            return false;
        }
        if (flag[i][j]) {
            return false;
        }
        flag[i][j] = true;
        charIndex++;
        if (search(board, flag, i, j + 1, word, charIndex)) {
            return true;
        } else if (search(board, flag, i + 1, j, word, charIndex)) {
            return true;
        } else if (search(board, flag, i, j - 1, word, charIndex)) {
            return true;
        } else if (search(board, flag, i - 1, j, word, charIndex)) {
            return true;
        } else {
            flag[i][j] = false;
        }
        return false;
    }
}
