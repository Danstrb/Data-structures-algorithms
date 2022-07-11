package com.utgard.queues;

import javax.sound.sampled.ReverbType;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueuePractice {
    public void queuePractice () {
   StackTwoQueues queue = new StackTwoQueues();

        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(40);
        queue.push(50);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

    }

//    public static void reverse (Queue<Integer> queue){
//        Stack<Integer> stack = new Stack<>();
//
//        while (!queue.isEmpty())
//            stack.push(queue.remove());
//        while (!stack.empty())
//            queue.add(stack.pop());
//    }
}
