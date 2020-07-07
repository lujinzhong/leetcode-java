package leetcode232;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class MyQueue {

    protected Stack<Integer> input;
    protected Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 先判断输出栈有没有东西，有的话直接弹出，没有的话，把输入栈搬到输出栈中
        if (!this.output.isEmpty()) {
            return this.output.pop();
        }
        while(!this.input.isEmpty()) {
            this.output.push(this.input.pop());
        }
        return this.output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 先判断输出栈有没有东西，有的话直接弹出，没有的话，把输入栈搬到输出栈中
        if (!this.output.isEmpty()) {
            return this.output.peek();
        }
        while(!this.input.isEmpty()) {
            this.output.push(this.input.pop());
        }
        return this.output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.input.isEmpty() && this.output.isEmpty();
    }
}
