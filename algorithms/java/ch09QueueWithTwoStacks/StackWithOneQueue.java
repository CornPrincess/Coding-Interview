package ch09QueueWithTwoStacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2/23/21
 * Time: 11:47 PM
 */
public class StackWithOneQueue {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public StackWithOneQueue() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 第一步先 push
        queue.offer(x);
        // 第二步把前面的变量重新倒腾一遍
        // 这一部分代码很关键，在树的层序遍历中也用到了
        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
