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

import java.util.BitSet;

public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

//    public static void main(String[] args) {
//        int a = Integer.MAX_VALUE;
//        System.out.println(a);
//        long b = a + 2L;
//        System.out.println(b);
//        long c = a + 2;
//        System.out.println(c);
//    }

//    public static void main(String[] args) {
//        int i = 1;
//        int j = i++;
//        if ((i == ++j)  && (i++ == j)) {
//            i += j;
//        }
//        System.out.println(i);
//    }

//    public static void main(String[] args) {
//        int num = 50;
//        int a = 50;
//        num = num++ * 2;
//        a = ++a * 2;
//        System.out.println(num); // 100
//        System.out.println(a); // 102
//    }

    public static void main(String[] args) {
//        int num = 10;
//        num = num++;
//        System.out.println(num);
//        int i = 1;
//        i=i++; // i = 1
//        int j = i++; // j = 1, i = 2
//        int k = i + ++i *i++; // k = 2+3*3 = 11, i = 4
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(k);
//        int a = 2;
//        int b = 2;
//        a++;
//        ++b;
//        System.out.println(a);
//        System.out.println(b);

//        int a = 2;
//        int b = ++a + a++ + ++a;
//        System.out.println(a);
//        System.out.println(b);

//        int a = 2;
//        a = a++ + a++;
//        System.out.println(a);

        int i = 1;
        i = i++; // 1
        int j = i++; // j = 1, i = 2
        int k = i + ++i * i++; // k = 2 + 3 * 3 = 11, i = 4
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
}
