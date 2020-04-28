package leetcode.hash;

import java.util.Arrays;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/22
 */
public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 2, 1, 7};
        //{1,1,2,2,3,7}
        //{1,2,3,4,5,6}
        System.out.println(minIncrementForUnique(arr));
    }

    public static int minIncrementForUnique(int[] A) {
        return mapToArrLinearProbingAndCompressRoute(A);
    }

    private static int mapToArrLinearProbingAndCompressRoute(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int[] map = new int[79999];
        Arrays.fill(map, -1);
        int count = 0;
        for (int i : A) {
            int position = getEmptyPositionAndCompressRoutePassedBy(i, map);
            count += (position - i);
        }
        return count;
    }

    private static int getEmptyPositionAndCompressRoutePassedBy(int num, int[] map) {
        if (map[num] == -1) {
            map[num] = num;
            return num;
        }
        int nextEmptyPositionExpect = map[num] + 1;
        int nextEmptyPositionActual = getEmptyPositionAndCompressRoutePassedBy(nextEmptyPositionExpect, map);
        map[num] = nextEmptyPositionActual;
        return nextEmptyPositionActual;
    }

    private static int mapToArrLinearProbing(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        boolean[] map = new boolean[79999];
        int count = 0;
        for (int i : A) {
            while (!map[i]) {
                i++;
                count++;
            }
            map[i] = true;
        }
        return count;
    }

    private static int mapToArrAndMoveBackward(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int[] map = new int[40001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            map[i]++;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (map[i] > 1) {
                int duplicateCount = map[i] - 1;
                count += duplicateCount;
                map[i + 1] += duplicateCount;
            }
        }
        if (map[max + 1] > 1) {
            int duplicateCount = map[max + 1] - 1;
            count += ((1 + duplicateCount) * duplicateCount / 2);
        }
        return count;
    }

    private static int sortAndIncrementByDegrees(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        for (int n = 1; n < A.length; n++) {
            if (A[n] <= A[n - 1]) {
                count += (A[n - 1] + 1 - A[n]);
                A[n] = A[n - 1] + 1;
            }
        }
        return count;
    }


}
