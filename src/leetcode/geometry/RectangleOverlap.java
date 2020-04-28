package leetcode.geometry;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 示例 1：
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/18
 */
public class RectangleOverlap {
    public static void main(String[] args) {
        //{x1,y1,x2,y2}
        int[] rec1 = new int[]{5, 15, 8, 18};
        int[] rec2 = new int[]{0, 3, 7, 9};

        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return judgeByAreaOverlap(rec1, rec2);
    }

    private static boolean judgeByLineOverlap(int[] rec1, int[] rec2) {
        return !((rec1[2] <= rec2[0] || rec1[3] <= rec2[1]) || (rec2[2] <= rec1[0] || rec2[3] <= rec1[1]));
    }

    private static boolean judgeByAreaOverlap(int[] rec1, int[] rec2) {
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }

}
