package leetcode.recursion.merge;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @author shiyuan.tian
 * @date 2020/2/29
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //{1,3,5,7,9},{2,4,6,8}
        //{1, 3},{2}
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            // total length is 9, find the 5th one, whose index is 4
            return getMedianNum(nums1, nums2, totalLength / 2);
        } else {
            // total length is 8, find the two of 4th and 5th, whose index are 3 and 4, compute the average of them
            return (getMedianNum(nums1, nums2, totalLength / 2 - 1) + getMedianNum(nums1, nums2, totalLength / 2)) / 2.0;
        }
    }

    static int getMedianNum(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k];
        }
        if (nums2.length == 0) {
            return nums1[k];
        }
        if (k == 0) {
            return Math.min(nums1[0], nums2[0]);
        }
        int m = Math.min(nums1.length - 1, (k - 1) / 2);
        int n = Math.min(nums2.length - 1, (k - 1) / 2);

        if (nums1[m] <= nums2[n]) {
            return getMedianNum(subList(m + 1, nums1.length, nums1), nums2, k - m - 1);
        } else {
            return getMedianNum(nums1, subList(n + 1, nums2.length, nums2), k - n - 1);
        }

    }

    static int[] subList(int fromIndex, int toIndex, int[] arr) {
        if (fromIndex == toIndex) {
            return new int[0];

        }
        int[] newArr = new int[toIndex - fromIndex];
        System.arraycopy(arr, fromIndex, newArr, 0, toIndex - fromIndex);
        return newArr;
    }
}