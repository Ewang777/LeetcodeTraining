package leetcode.sort;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/18
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        quickSort(intervals, 0, intervals.length - 1);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                intervals[++index] = intervals[i];
            }
        }
        int[][] result = new int[index + 1][2];
        System.arraycopy(intervals, 0, result, 0, result.length);
        return result;
    }

    private static void quickSort(int[][] intervals, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (i != j) {
            while (intervals[j][0] >= intervals[left][0] && j > i) {
                j--;
            }
            while (intervals[i][0] <= intervals[left][0] && j > i) {
                i++;
            }
            if (i < j) {
                swap(intervals, i, j);
            }
        }
        swap(intervals, left, i);
        quickSort(intervals, left, i - 1);
        quickSort(intervals, i + 1, right);
    }

    private static void swap(int[][] target, int from, int to) {
        int[] temp = target[from];
        target[from] = target[to];
        target[to] = temp;
    }
}
