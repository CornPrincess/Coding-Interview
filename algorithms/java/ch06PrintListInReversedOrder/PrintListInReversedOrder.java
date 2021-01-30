// Source : https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
// Author : cornprincess
// Date   : 2020-07-17

/***************************************************************************************************** 
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 * 示例 1：
 * 
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 
 * 限制：
 * 
 * 0 <= 链表长度 <= 10000
 ******************************************************************************************************/

package ch06PrintListInReversedOrder;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PrintListInReversedOrder {

    /*
     * use stack iterator
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    /*
     * use stack, recursive
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public int[] reversePrint2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursive(head, list);
        int[] print = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            print[i] = list.get(i);
        }
        return print;
    }

    private void recursive(ListNode node, List<Integer> list) {
        if (node != null) {
            if (node.next != null) {
                recursive(node.next, list);
            }
            list.add(node.val);
        }
    }

    int[] ans;
    int num = 0;
    int index = 0;
    public int[] reversePrint3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursive2(head);
        return ans;
    }

    private void recursive2(ListNode node) {
        if (node == null) {
            ans = new int[num];
            return;
        }
        num++;
        recursive2(node.next);
        ans[index++] = node.val;
    }
}

