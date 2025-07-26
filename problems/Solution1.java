package problems;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public static void main(String[] args) {
    int[] stockPrice = {1,5,3,7,8};
    System.out.println(getMaximumScore(5, stockPrice));
  }
  // [1,5,3,7,8]
  //  1 2 3 4 5

  //    5   7 8
  //    2   4 5
  public static int getMaximumScore(int n, int[] stockPrice) {
    Map<Integer, Integer> map = new HashMap<>(); // difference： sum of stock prices
    int maxm = 0;
    for (int i = 0; i < n; i++) {
      int diff = stockPrice[i] - i;

      if (map.containsKey(diff)) {
        map.put(diff, map.get(diff) + stockPrice[i]);
      }
      else {
        map.put(diff, stockPrice[i]);
      }
    }
    for (Map.Entry<Integer, Integer> pair :
        map.entrySet()) {
      if (pair.getValue() > maxm) {
        maxm = pair.getValue();
      }
    }
    return maxm;
  }
}
          