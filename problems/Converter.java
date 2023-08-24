package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Converter {

  public static void main(String[] args) {
    int a1 = 1, b1 = 2;
    int a2 = 9, b2 = 1;
    int a3 = 2, b3 = 10;
    int a4 = 100, b4 = 500;
    Converter c = new Converter();

    System.out.println(c.convert(a1, b1));
    System.out.println(c.convert(a2, b2));
    System.out.println(c.convert(a3, b3));
    System.out.println(c.convert(a4, b4));
  }

  public int convert(int a, int b) {
    if (a > b) {
      return a - b;
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(a);
    int cnt =  0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int curr = queue.poll();
        if (curr == b) {
          return cnt;
        }
        if (curr * 2 <= b) {
          queue.offer(curr * 2);
        }
        if (curr - 1 > 0) {
          queue.offer(curr - 1);
        }
      }
      cnt++;
    }
    return  -1;
  }

}
