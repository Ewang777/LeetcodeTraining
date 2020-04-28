package leetcode.structure.linkedlist;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/4
 */
public class RemoveDuplicateLinkedNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(2);

        ListNode result = removeDuplicateNodes(node);
        System.out.println(result);
    }


    public static ListNode removeDuplicateNodes(ListNode head) {
        return useExtraSpace(head);
    }

    private static ListNode useExtraSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int[] hash = new int[20001];
        ListNode cleanPre = head, current = head.next;
        hash[head.val]++;
        while (current != null) {
            hash[current.val]++;
            if (hash[current.val] == 1) {
                cleanPre.next = current;
                cleanPre = cleanPre.next;
            }
            current = current.next;
        }
        cleanPre.next = null;
        return head;
    }

    private static ListNode useNoExtraSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cleanCurrent = head, search = head.next;
        while (search != null) {
            ListNode index = head;
            boolean duplicated = false;
            while (index != cleanCurrent.next) {
                if (index.val == search.val) {
                    duplicated = true;
                    break;
                }
                index = index.next;
            }
            if (!duplicated) {
                cleanCurrent.next = search;
                cleanCurrent = cleanCurrent.next;
            }
            search = search.next;
        }
        cleanCurrent.next = null;
        return head;
    }
}
