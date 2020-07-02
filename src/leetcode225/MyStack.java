package leetcode225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 */
public class MyStack {

    protected Queue<Integer> queue;
    protected Queue<Integer> queue2;
    protected int last;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        // 输出和输出队列
        this.queue = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!this.queue.isEmpty()) {
            this.queue.add(x);
        } else {
            this.queue2.add(x);
        }
        this.last = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //重新入队，从非空的跑到空的
        if (this.queue.isEmpty()) {
            while (this.queue2.size() > 1) {
                this.last = this.queue2.poll();
                this.queue.add(this.last);
            }
            return this.queue2.poll();
        }else {
            while (this.queue.size() > 1) {
                this.last = this.queue.poll();
                this.queue2.add(this.last);
            }
            return this.queue.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.last;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.queue2.isEmpty() && this.queue.isEmpty();
    }
}
