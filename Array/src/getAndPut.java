package Array.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class getAndPut {
  public static ArrayList<Integer> list = new ArrayList<>();
  public static ArrayList<Integer> removedList = new ArrayList<>();
  public Random rand = new Random();

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++){
      list.add(i+1);
    }
    getAndPut arr = new getAndPut();
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());
    //=====================
    System.out.println("------------------");
    arr.put();
    arr.put();
    arr.put();
    System.out.println(arr.get());
    System.out.println(arr.get());
    System.out.println(arr.get());

  }
  public int get() {
    int idx = rand.nextInt(list.size()) ; //从index 0 - 9 随机生成一个
    int res = list.get(idx);

    int last = list.get(list.size() - 1);
    list.set(idx, last); //用最后一位元素替代要被移除元素的位置
    removedList.add(res);
    list.remove(list.size()-1); //删除最后一位元素
    return res;
  }

  public void put() {
      int idx = rand.nextInt(removedList.size());
      list.add(removedList.get(idx));

      int last = removedList.get(removedList.size() - 1);
      removedList.set(idx, last); //用最后一位元素替代要被移除元素的位置
      removedList.remove(removedList.size()-1); //删除最后一位元素
  }

}
