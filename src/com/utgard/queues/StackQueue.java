package com.utgard.queues;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();


    public void enqueue (int item) {
        moveStack1ToStack2(stack1, stack2);

        stack1.push(item);
    }

    public int dequeue () {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2(stack2, stack1);

        return stack2.pop();
    }
//    public int dequeue () {
//        for (int i = 1; i < count; i++)
//            stack2.push(stack1.pop());
//        var dequeuedItem = stack1.pop();
//        while (!stack2.empty())
//            stack1.push(stack2.pop());
//        count--;
//        return dequeuedItem;
//    }

    public int peek () {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2(stack2, stack1);

        return stack2.peek();
    }

    private void moveStack1ToStack2(Stack<Integer> stack2, Stack<Integer> stack1) {
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }

    @Override
    public String toString() {
        if (stack1.empty())
            return stack2.toString();
        else
            return stack1.toString();
    }
}
