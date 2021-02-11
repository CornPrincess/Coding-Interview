package ch07ConstructBinaryTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2021-02-07
 * Time: 22:47
 */
public class ConstructBinaryTreeTest {
    ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
    TreeNode treeNode;

    @Before
    public void init() {
        treeNode = constructBinaryTree.initTree();
    }

    @Test
    public void buildTree() {
        int length = 8;
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = constructBinaryTree.buildTree(preorder, inorder);
        constructBinaryTree.front_order_print(treeNode);
        System.out.println();
        constructBinaryTree.middle_order_print(treeNode);
    }

    @Test
    public void front_order_print() {
        constructBinaryTree.front_order_print(treeNode);
    }

    @Test
    public void middle_order_print() {
        constructBinaryTree.middle_order_print(treeNode);
    }

    @Test
    public void back_order_print() {
        constructBinaryTree.back_order_print(treeNode);
    }

}
