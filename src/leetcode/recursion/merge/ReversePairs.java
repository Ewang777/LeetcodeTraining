package leetcode.recursion.merge;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/16
 */
public class ReversePairs {
    private static int count = 0;

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 3, 1};
        System.out.println(reversePairs(input));
    }

    public static int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        divide(0, nums.length - 1, nums);
        return count;
    }

    private static void divide(int left, int right, int[] nums) {
        if (left == right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        divide(left, mid, nums);
        divide(mid + 1, right, nums);
        merge(left, mid, right, nums);
    }


    private static void merge(int left, int mid, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

}
