package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/13
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,5};
        System.out.println(majorityElement(arr));
    }

    private static Map<Integer, Integer> countMap = new HashMap<>();

    /**
     * 摩尔投票法
     */
    public static int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            if (num == majority) {
                count++;
            } else {
                count--;

            }
        }
        return majority;
    }

    private static int hash(int[] nums) {
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
