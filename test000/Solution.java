package test000;

import java.util.HashMap;
import java.util.Random;

public class Solution {
  //先在外部定义变量类型
  HashMap<Integer, Integer> map;
  int[] nums;
  Random random;
    static int temp = 0;
  public  Solution() { //构造器 Instructor
    //在构造器内初始化
    map = new HashMap<>();
    nums = new int[100];
    random = new Random();
  }
  public static boolean add(int k) { //类里的method
    System.out.println("success");
    temp++;
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //调用类时
    Solution.add(5); //调用类内部的方法
  }

  public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode (int val) {this.val = val;}
    public ListNode (int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {this.val = val;}
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}



