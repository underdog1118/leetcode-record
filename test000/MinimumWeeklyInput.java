package test000;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinimumWeeklyInput {

  public static void main(String[] args) {
//    System.out.println(minimumWeeklyInput(new int[]{1000, 500, 2000, 8000, 1500}, 3)); //9500
//    System.out.println(minimumWeeklyInput(new int[]{3000, 1000, 4000}, 2)); //7000
//    System.out.println(minimumWeeklyInput(new int[]{190, 200, 450, 499, 350,160}, 3)); //849
//    System.out.println(minimumWeeklyInput(new int[]{3000, 500, 2000, 8000, 1500,600}, 3)); //11500
//    System.out.println(minimumWeeklyInput(new int[]{3000, 500, 2000, 8000, 1500,600,300}, 3)); //8900
//    System.out.println(minimumWeeklyInput(new int[]{3000, 500, 2000, 8000, 1500,4000,300}, 3)); //11300

    System.out.println("-----------");

//    System.out.println(minimumWeeklyInput2(new int[]{1000, 500, 2000, 8000, 1500}, 3));
//    System.out.println(minimumWeeklyInput2(new int[]{3000, 1000, 4000}, 2));
    System.out.println(minimumWeeklyInput2(new int[]{190, 200, 450, 499, 350,160}, 3));
//    System.out.println(minimumWeeklyInput2(new int[]{3000, 500, 2000, 8000, 1500,600}, 3));
//    System.out.println(minimumWeeklyInput2(new int[]{3000, 500, 2000, 8000, 1500,600,300}, 3));
//    System.out.println(minimumWeeklyInput2(new int[]{3000, 500, 2000, 8000, 1500,4000,300}, 3));
  }

  public static int res = Integer.MAX_VALUE;
  public static int cnt = 0;
  public static int minimumWeeklyInput2(int[] costs, int weeks) {
    int n = costs.length;
    backtrack(costs, 0, 0, weeks);
    return res;
  }
  public static void backtrack(int[] nums, int idx, int sum, int weeks) {
    // 2.组合 ： k个数字的组合，只要长度为k的
    if (cnt == weeks && idx == nums.length) {
      res = Math.min(res, sum);
      return;
    }
    //for循环遍历数组nums
    for (int i = idx; i < nums.length; i++) {
      //做选择，将选择添加到路径数组中
      int max = Integer.MIN_VALUE;
      for (int j = idx; j <= i; j++) {
        max = Math.max(max, nums[j]);
      }
      sum += max;
      cnt++;
      //回溯，继续向数组中下一个数字遍历
      backtrack(nums, i+1, sum, weeks);  //*** 注意是i+1而不是index+1 ***
      //撤销选择，将选择从路径中删除
      sum -= max;
      cnt--;
    }
  }







  public static int minimumWeeklyInput(int[] costs, int weeks) {
    int n = costs.length;
    int[] dp = new int[weeks];
    for (int i = 0; i < weeks; i++) {
      dp[i] = costs[i];
    }
    for (int i = weeks; i < n; i++) {
        int j = weeks - 1;
        if (costs[i] > dp[j]) {
          dp[weeks-1] = costs[i];
        }
        else if (costs[i] < dp[j-1]) {
          dp[j-1] = dp[j];
          dp[j] = costs[i];
        }
      }

    int sum = 0;
    for (int i = 0; i < weeks; i++) {
      sum += dp[i];
    }

    return  sum;
  }

}
