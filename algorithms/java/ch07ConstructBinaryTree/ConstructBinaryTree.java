// Source : https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
// Author : cornprincess
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重
 * 复的数字。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 5000
 * 
 * 注意：本题与主站 105 
 * 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 ******************************************************************************************************/

package ch07ConstructBinaryTree;

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public void front_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        front_order_print(root.left);
        front_order_print(root.right);
    }

    public void middle_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        middle_order_print(root.left);
        System.out.println(root.val);
        middle_order_print(root.right);
    }

    public void back_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        back_order_print(root.left);
        back_order_print(root.right);
        System.out.println(root.val);
    }

    public TreeNode initTree() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1_1 = new TreeNode(2);
        TreeNode treeNode1_2 = new TreeNode(3);
        TreeNode treeNode1_1_1 = new TreeNode(4);
        TreeNode treeNode1_1_2 = new TreeNode(5);
        TreeNode treeNode1_2_1 = new TreeNode(6);
        TreeNode treeNode1_2_2 = new TreeNode(7);
        root.left = treeNode1_1;
        root.right = treeNode1_2;
        treeNode1_1.left = treeNode1_1_1;
        treeNode1_1.right = treeNode1_1_2;
        treeNode1_2.left = treeNode1_2_1;
        treeNode1_2.right = treeNode1_2_2;
        return root;
    }
}
