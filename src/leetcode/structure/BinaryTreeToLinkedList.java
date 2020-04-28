package leetcode.structure;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author shiyuan.tian
 * @date 2020/3/12
 */
public class BinaryTreeToLinkedList {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.left.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        ListNode result = flatten2(root);
        System.out.println(result.toString());
    }

    private static TreeNode next = null;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        next = root;
        root.left = null;
    }

    private static ListNode flatten2(TreeNode root) {
        if (root == null) {
            return null;
        }
        ListNode current = new ListNode(root.val);
        current.next = flatten2(root.left);
        ListNode right = flatten2(root.right);
        if (current.next == null) {
            current.next = right;
        } else {
            ListNode tail = current;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = right;
        }
        return current;
    }
}
