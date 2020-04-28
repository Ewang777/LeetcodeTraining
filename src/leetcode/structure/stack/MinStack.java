package leetcode.structure.stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/11
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.min();// 返回 -3.
        minStack.pop();
        int top = minStack.top();// 返回 0.
        int min1 = minStack.min();// 返回 -2.
    }

    private static class Node {
        private int value;
        private int min;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            head.min = x;
        } else {
            Node insert = new Node(x);
            insert.min = Math.min(x, head.min);
            insert.next = head;
            head = insert;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int min() {
        return head.min;
    }
}
