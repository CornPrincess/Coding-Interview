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
 * 前序遍历 preorder = [3,| 9,| 20,15,7]
 * 中序遍历 inorder = [9,| 3, |15,20,7]
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

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        // inorder root hashmap
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree0(preorder, inorder,0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree0(int[] preordr, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 终止条件
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 中序遍历中定位根节点
        int inorder_root = indexMap.get(preordr[preorder_root]);

        // 建立根节点
        TreeNode root = new TreeNode(preordr[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归构造左子树并链接到根节点
        root.left = buildTree0(preordr, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归构造右子树，并连接到根节点
        root.right = buildTree0(preordr, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

    public void front_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        front_order_print(root.left);
        front_order_print(root.right);
    }

    public void middle_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        middle_order_print(root.left);
        System.out.print(root.val);
        middle_order_print(root.right);
    }

    public void back_order_print(TreeNode root) {
        if (root == null) {
            return;
        }
        back_order_print(root.left);
        back_order_print(root.right);
        System.out.print(root.val);
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
