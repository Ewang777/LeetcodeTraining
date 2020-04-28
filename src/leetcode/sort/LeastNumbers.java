package leetcode.sort;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author shiyuan.tian
 * @date 2020/3/20
 */
public class LeastNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 75)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
//        partitionQuickSort(0, arr.length - 1, arr, k);
//        int[] result = new int[k];
//        System.arraycopy(arr, 0, result, 0, k);
//        return result;
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        System.arraycopy(arr, 0, result, 0, k);
        buildMaxHeap(result);
        for (int i = k; i < arr.length; i++) {
            if(arr[i]<result[0]){
                result[0] = arr[i];
                buildMaxHeap(result);
            }
        }
        return result;
    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(i, 0, arr);
            adjustHeap(arr, 0, i);
        }
    }
    private static void buildMaxHeap(int[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (arr[parent] >= arr[lChild]) {
                break;
            }
            swap(parent, lChild, arr);

            parent = lChild;
            lChild = 2 * lChild + 1;
        }
    }


    private static void partitionQuickSort(int left, int right, int[] arr, int k) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (j != i) {
            while (arr[j] >= arr[left] && j > i) {
                j--;
            }
            while (arr[i] <= arr[left] && j > i) {
                i++;
            }
            if (i < j) {
                swap(i, j, arr);
            }
        }
        swap(left, i, arr);
        if (i > k) {
            partitionQuickSort(left, i, arr, k);
        } else if (i < k) {
            partitionQuickSort(i + 1, right, arr, k);
        }
    }

    private static void swap(int from, int to, int[] arr) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }
}
