package leetcode.structure.linkedlist;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author shiyuan.tian
 * @date 2020/3/14
 */
public class MergeKSortedLinkedLists {

    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode result = mergeKLists(new ListNode[]{new ListNode(1), new ListNode(0)});
        System.out.println(result.toString());

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        } else if (k == 1) {
            return lists[0];
        } else if (k == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        } else {
            int middle = k / 2;
            return mergeTwoLists(mergeKLists(subList(0, middle, lists)), mergeKLists(subList(middle, k, lists)));
        }
    }

    private static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode head;
        if (listNode1.val <= listNode2.val) {
            head = listNode1;
            head.next = mergeTwoLists(listNode1.next, listNode2);
        } else {
            head = listNode2;
            head.next = mergeTwoLists(listNode1, listNode2.next);
        }
        return head;
    }

    private static ListNode[] subList(int fromIndex, int endIndex, ListNode[] toSubList) {
        if (fromIndex >= endIndex) {
            return new ListNode[0];
        }
        ListNode[] listNodes = new ListNode[endIndex - fromIndex];
        if (endIndex - fromIndex >= 0) {
            System.arraycopy(toSubList, fromIndex, listNodes, 0, endIndex - fromIndex);
        }
        return listNodes;
    }
}
