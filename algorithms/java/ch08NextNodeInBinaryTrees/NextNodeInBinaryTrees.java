package ch08NextNodeInBinaryTrees;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2021-02-18
 * Time: 23:35
 *
 *  面试题8：二叉树的下一个结点
 *  题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *  树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class NextNodeInBinaryTrees {

    // has bug
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 参数检查
        if (pNode == null || pNode.parent == null) {
            return null;
        }

        TreeLinkNode result = null;
        // 如果存在右子树，下一个节点为该右子树的最左子节点
        if (pNode.right != null) {
            result = pNode.right;
            while (result.left != null) {
                result = result.left;
            }
        } else {
            // 不存在右子树
            // 指定节点为父节点的左子树，下一个节点为指定节点的父节点
            if (pNode == pNode.parent.left) {
                result = pNode.parent;
            } else {
                // 指定节点为父节点的右子树，一直向上找，直到找到是父节点的左节点的点，下一个节点就是这个点的父节点，找不到则说明没有这个点
                while (pNode.parent != null) {
                    if (pNode.parent.parent != null && pNode.parent == pNode.parent.parent.left) {
                        result = pNode.parent.parent;
                        break;
                    }
                    pNode = pNode.parent;
                }

            }
        }
        return result;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 参数检查
        if (pNode == null) {
            return null;
        }

        TreeLinkNode result = null;

        if (pNode.right != null) {
            result = pNode.right;
            while (result.left != null) {
                result = result.left;
            }
        } else if (pNode.parent != null) {
            // 这里将两种情况进行合并，秒
            // 并且这里用了两个变量，可以理解为双指针，自己的代码这样写就容易产生bug
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            result = parent;
        }
        return result;
    }

}
