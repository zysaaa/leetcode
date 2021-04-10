package com.zysaaa.zysaaa20210225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author:zysaaa
 * @date: 2021/4/5 18:32
 */
public class MyStack {

    private Queue<Integer> queue;
    private LinkedList<Integer> linkedList2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
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
