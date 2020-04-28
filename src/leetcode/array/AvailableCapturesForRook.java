package leetcode.array;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * 返回车能够在一次移动中捕获到的卒的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/26
 */
public class AvailableCapturesForRook {
    public static void main(String[] args) {
        char[][] board = {
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , 'p' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , 'p' , '.' , '.' , '.' , '.'},
                {'p' , 'p' , '.' , 'R' , '.' , 'p' , 'B' , '.'},
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , 'B' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , 'p' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'}
        };

        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int rowOfRook = 0;
        int columnOfRook = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rowOfRook = i;
                    columnOfRook = j;
                }
            }
        }
        //东南西北
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int x = rowOfRook + dx[i], y = columnOfRook + dy[i];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                char current = board[x][y];
                if (current == 'p') {
                    count++;
                    break;
                } else if (current == 'B') {
                    break;
                }
                x += dx[i];
                y += dy[i];
            }

        }
        return count;
    }


}
