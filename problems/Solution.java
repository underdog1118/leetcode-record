package problems;

//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
import java.util.*;


class Solution {
  public static void main(String[] args) {
    System.out.println("1");
    String[] strs = new String[]{"pacific" , "capicfi" , "atlanta" , "pouere" , "cipacfi" , "tanlaat","europe"};
    List<List<String>>  res = group(strs);
    System.out.println(res);
  }
  //   sList = ["pacific" , "capicfi" , "atlanta" , "pouere" , "cipacfi" , "tanlaat","europe"]

//  output = [["pacific" , "capicfi" , "cipacfi"] , ["atlanta" , "tanlaat"] , ["pouere","europe"]]

  // O(n * K)  n - strs len   , K - maximum len in strs
  // O(NK)

  public static List<List<String>>  group(String[] strs) {
    List<List<String>> res = new LinkedList<>();

    HashMap<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      String ss = encode(s);
      map.putIfAbsent(ss, new LinkedList<>()); // pac -> 1  cap -> 1  cipacfi-> 1   key: 1  val: pacific , capicfi, cipacfi
      //atlanta -> 2   val:atlanta

      map.get(ss).add(s);
    }

    for (String s : map.keySet()) {
      List<String> l  = map.get(s);
      res.add(new LinkedList<>(l));
    }
    return res;
  }

  public static String encode(String s) {
    char[] arr = new char[26];  // p : 1  c : 2  i : 2 a : 1
    // 102020001
    // 1002033
    for (char c : s.toCharArray()) {
      arr[c - 'a'] ++;
    }
    String res = String.valueOf(arr);
    return res;
  }
}
