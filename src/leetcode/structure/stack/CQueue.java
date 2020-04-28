package leetcode.structure.stack;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/11
 */
public class CQueue {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        int i = queue.deleteHead();
        queue.appendTail(5);
        queue.appendTail(2);
        int i1 = queue.deleteHead();
        int i2 = queue.deleteHead();
    }

    private Stack<Integer> push;
    private Stack<Integer> pop;

    public CQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void appendTail(int value) {
        while (!pop.isEmpty()) {
            push.push(pop.pop());
        }
        push.push(value);
    }

    public int deleteHead() {
        if (!pop.isEmpty()) {
            return pop.pop();
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
        if (pop.isEmpty()) {
            return -1;
        } else {
            return pop.pop();
        }
    }
}
