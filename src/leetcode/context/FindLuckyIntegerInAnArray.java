package leetcode.context;

/**
 * @author shiyuan.tian
 * @date 2020/3/29
 */
public class FindLuckyIntegerInAnArray {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        int[] map = new int[501];
        for (int num : arr) {
            map[num]++;
        }
        int maxLuckyNum = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 && map[i] == i) {
                maxLuckyNum = Math.max(maxLuckyNum, map[i]);
            }
        }
        return maxLuckyNum == Integer.MIN_VALUE ? -1 : maxLuckyNum;
    }
}
