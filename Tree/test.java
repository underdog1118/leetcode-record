package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class test {

  public static void main(String[] args) {
    test t = new test();
    List<List<Integer>> nums = new ArrayList<>();
    nums.add(Arrays.asList(4,10,15,24,26));
    nums.add(Arrays.asList(0,9,12,20));
    nums.add(Arrays.asList(5,18,22,30));
    System.out.println(t.smallestRange(nums));
  }

  public int[][] smallestRange(List<List<Integer>> nums) {
    int n = 0; //所有数字的数量
    for (int i = 0; i < nums.size(); i++) {
      n += nums.get(i).size();
    }

    int[][] arr = new int[n][2];  //有从0到n-1共n组数据
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        arr[cnt][0] = nums.get(i).get(j);
        arr[cnt][1] = i;
        cnt++;
      }
    }
    return arr;

  }


}
