package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/30
 */
public class Joseph {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        System.out.println(lastRemaining(n, m));
    }


    public static int lastRemaining(int n, int m) {
        //1.   f(n,m)，f(n-1,m)，...，f(2,m)，f(1,m)
        //2.   实际上，f(n,m)相对于f(n-1,m)，即移除了第一个数。而f(1,m)移除的数，实则就是所求的最后一个数，不过此时其下标（是在当前序列长度中的下标）为0。我们无法知道当前序列，已知项只有原有序列及其位置。（arr[0]=0,arr[1]=1,...,arr[n-1]=n-1）
        //3.   所以我们需要求的，是将最后一个数f(1,m)的相对下标0—转化为—原有序列中的下标。
        //4.   如2所说，f(n,m)相对于f(n-1,m)，即移除了第一个数，被移除的数下标为m%n。故f(n-1,m)相对于f(n-2,m)中被移除的第二个数，其在原有序列中的下标即为**当前下标+m%n**，成环则对于当前长度进行取模即可
        return useRecursion(n, m);
    }

    private static int useRecursion(int n, int m) {
        // f(1,m) = 0
        // (f(1,m) + m) % 2 = f(2,m)
        // (f(2,m) + m) % 3 = f(3,m)
        // ...
        // (f(n-1,m) + m) % n = f(n,m)
        if (n == 1) {
            return 0;
        }
        return (useRecursion(n - 1, m) + m) % n;

    }

    private static int useExtraArrayList(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() > 1) {
            current = (current + m - 1) % list.size();
            list.remove(current);
        }
        return list.get(0);
    }
}
