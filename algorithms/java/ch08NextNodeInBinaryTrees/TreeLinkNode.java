package ch08NextNodeInBinaryTrees;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2021-02-21
 * Time: 15:05
 */
public class TreeLinkNode {
     int val;
     TreeLinkNode left;
     TreeLinkNode right;
     TreeLinkNode parent;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right, TreeLinkNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
