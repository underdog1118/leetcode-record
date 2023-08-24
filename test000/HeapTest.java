package test000;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HeapTest {

  public static void main(String[] args) {
    HashMap<Integer, Integer> numToFreq = new HashMap<>(); // num - freq
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (n1,n2) -> (numToFreq.get(n2) != numToFreq.get(n1)) ? numToFreq.get(n2) - numToFreq.get(n1) : n2 - n1
    );
    System.out.println("---------1----------");
    numToFreq.put(1, numToFreq.getOrDefault(1, 0) + 1);
    if (!maxHeap.contains(1)) {
      maxHeap.add(1);
    }
    System.out.println(maxHeap);
    System.out.println(numToFreq);
    System.out.println(maxHeap.peek());

    System.out.println("---------2-----------");
    numToFreq.put(2, numToFreq.getOrDefault(2, 0) + 1);
    if (!maxHeap.contains(2)) {
      maxHeap.add(2);
    }
    System.out.println(maxHeap);
    System.out.println(numToFreq);
    System.out.println(maxHeap.peek());

    System.out.println("----------3----------");
    numToFreq.put(5, numToFreq.getOrDefault(5, 0) + 1);

    maxHeap.clear();
    maxHeap.addAll(numToFreq.keySet());

    System.out.println(maxHeap);
    System.out.println(numToFreq);
    System.out.println(maxHeap.peek());


    System.out.println("----------4---------");
    numToFreq.put(1, numToFreq.getOrDefault(1, 0) + 1);
//    if (maxHeap.contains(1)) {  //重要！！！
//      maxHeap.remove(1);
//    }
//    maxHeap.addAll(1);

    maxHeap.clear();
    maxHeap.addAll(numToFreq.keySet());

    System.out.println(maxHeap);
    System.out.println(numToFreq);
    System.out.println(maxHeap.peek());

  }

//  public void add (PriorityQueue<Character> maxHeap, int num) {
//    maxHeap.offer(num);
//  }

}
