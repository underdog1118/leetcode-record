package problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Test {
  public static class Student {
    int num;
    String name;
    public Student(int num, String name) {
      this.num = num;
      this.name = name;
    }

    /**
     * equals method for the class
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Student student = (Student) o;
      return num == student.num && Objects.equals(name, student.name);
    }

    /**
     * hashCode method for the class
     */
    @Override
    public int hashCode() {
      return Objects.hash(num, name);
    }
  }
  public static void main(String[] args) {
    Student s1 = new Student(1, "1");
    Student s2 = new Student(2, "2");
    System.out.println(s1.equals(s2));


    PriorityQueue<Student> students = new PriorityQueue<>(new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        return o1.num - o2.num;
      }
    });

    students.offer(new Student(2,"2"));
    if (!students.contains(new Student(2,"2"))) {
      students.offer(new Student(2, "2"));
    }

    System.out.println(students.size());

    students.remove(new Student(2,"2"));
    System.out.println(students.size());

//    Map<Integer, Integer> map = new HashMap<>();
//    map = new TreeMap<>();
//    Queue<Integer> queue = new LinkedList<>();

//    Collection


//    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//    minHeap.offer(1);
//    minHeap.offer(1);
//    minHeap.offer(2);
//    minHeap.offer(3);
//    System.out.println(minHeap.peek());
//
//    minHeap.remove(1);
//    System.out.println(minHeap.size());
//    System.out.println(minHeap.peek());
//
//    minHeap.remove(1);
//    System.out.println(minHeap.size());
//    System.out.println(minHeap.peek());
//
//    minHeap.remove(3);
//    System.out.println(minHeap.size());
//    System.out.println(minHeap.peek());
//
//
//    List<Integer> arr = new ArrayList<>();
//    ArrayList<Integer> arr2 = new ArrayList<>();
//
//
//    LinkedList<Integer> linkedList = new LinkedList<>();
//
//    List<Integer> linkedList2 = new LinkedList<>();
//    ((LinkedList<Integer>) linkedList2).addFirst(1);
  }
}
