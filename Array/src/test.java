package Array.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.peek());
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
