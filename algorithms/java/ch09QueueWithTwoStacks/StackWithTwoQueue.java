package ch09QueueWithTwoStacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2/23/21
 * Time: 11:28 PM
 */
public class StackWithTwoQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackWithTwoQueue() {
        // 用两个队列的核心是要互相倒腾，
        // 其中queue2的作用只是临时存放遍历
        // 所有的遍历都存放在queue1中
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }


    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
