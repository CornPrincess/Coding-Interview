package ch08NextNodeInBinaryTrees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2/22/21
 * Time: 11:47 PM
 */
public class NextNodeInBinaryTreesTest {

    private TreeLinkNode root;

    @Before
    public void init_tree() {
        root = new TreeLinkNode(8);
        TreeLinkNode node1 = new TreeLinkNode(6);
        TreeLinkNode node2 = new TreeLinkNode(10);
        TreeLinkNode node1_1 = new TreeLinkNode(5);
        TreeLinkNode node1_2 = new TreeLinkNode(7);
        TreeLinkNode node2_1 = new TreeLinkNode(9);
        TreeLinkNode node2_2 = new TreeLinkNode(11);
        root.left = node1;
        root.right = node2;
        node1.parent = root;
        node2.parent = root;
        node1.left = node1_1;
        node1.right = node1_2;
        node1_1.parent = node1;
        node1_2.parent = node1;
        node2.left = node2_1;
        node2.right = node2_2;
        node2_1.parent = node2;
        node2_2.parent = node2;

        NextNodeInBinaryTrees n = new NextNodeInBinaryTrees();
        TreeLinkNode treeLinkNode = n.GetNext(node1_2);
        System.out.println(treeLinkNode.val);
    }

    @Test
    public void getNext() {
        System.out.println("start");
    }


}
