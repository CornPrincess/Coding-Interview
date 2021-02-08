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
        constructBinaryTree.front_order_print(treeNode);
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
