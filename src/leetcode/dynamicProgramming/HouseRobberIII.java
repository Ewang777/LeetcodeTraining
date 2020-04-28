package leetcode.dynamicProgramming;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * TODO
 *
 * @author shiyuan.tian
 * @date 2020/3/24
 */
public class HouseRobberIII {

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        return recordTwoKindOfLocalBestWithPostOrder(root);
    }

    private static int recordTwoKindOfLocalBestWithPostOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] twoKindOfLocalBest = getTwoKindOfLocalBest(root);
        return Math.max(twoKindOfLocalBest[0], twoKindOfLocalBest[1]);
    }

    private static int[] getTwoKindOfLocalBest(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] twoKindOfLocalBestOfLeftChild = getTwoKindOfLocalBest(root.left);
        int[] twoKindOfLocalBestOfRightChild = getTwoKindOfLocalBest(root.right);

        int chooseCurrentNode = root.val;
        int nonChooseCurrentNode = 0;

        chooseCurrentNode += twoKindOfLocalBestOfLeftChild[0] + twoKindOfLocalBestOfRightChild[0];
        nonChooseCurrentNode += Math.max(twoKindOfLocalBestOfLeftChild[0], twoKindOfLocalBestOfLeftChild[1])
                + Math.max(twoKindOfLocalBestOfRightChild[0], twoKindOfLocalBestOfRightChild[1]);
        return new int[]{nonChooseCurrentNode, chooseCurrentNode};
    }


    private static int recordLocalBestInTreeWithPostOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recordLocalBestInTreeWithPostOrder(root.left);
        recordLocalBestInTreeWithPostOrder(root.right);

        int chooseCurrentNode = root.val;
        int nonChooseCurrentNode = 0;

        if (root.left != null) {
            nonChooseCurrentNode += root.left.val;
            if (root.left.left != null) {
                chooseCurrentNode += root.left.left.val;
            }
            if (root.left.right != null) {
                chooseCurrentNode += root.left.right.val;
            }
        }
        if (root.right != null) {
            nonChooseCurrentNode += root.right.val;
            if (root.right.left != null) {
                chooseCurrentNode += root.right.left.val;
            }
            if (root.right.right != null) {
                chooseCurrentNode += root.right.right.val;
            }
        }
        root.val = Math.max(chooseCurrentNode, nonChooseCurrentNode);
        return root.val;
    }

}
