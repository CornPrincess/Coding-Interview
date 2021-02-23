package ch09QueueWithTwoStacks;

// Source : https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
// Author : cornprincess
// Date   : 2021-02-23

import java.util.Stack;

/*****************************************************************************************************
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead 
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * 示例 1：
 * 
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 
 * 示例 2：
 * 
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 
 * 提示：
 * 
 * 	1 <= values <= 10000
 * 	最多会对 appendTail、deleteHead 进行 10000 次调用
 ******************************************************************************************************/

public class QueueWithTwoStacks {
    // 用作push
    Stack<Integer> stack1 = new Stack<>();
    // 用作pop
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
             return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

