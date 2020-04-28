package leetcode.structure.linkedlist;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/3
 */
public class RandomLinkedList {
    /**
     * Definition for a Node.
     */
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        Node result = copyRandomList(node7);
        System.out.println(result);
    }

    public static Node copyRandomList(Node head) {
        // * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        // * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //1->1'->2->2'->3->3'
        current = head;
        Node copyHead = head.next, copyCurrent = head.next;
        while (current.next.next != null) {
            current.next = current.next.next;
            current = current.next;
            copyCurrent.next = copyCurrent.next.next;
            copyCurrent = copyCurrent.next;
        }
        current.next = null;
        return copyHead;
    }
}
