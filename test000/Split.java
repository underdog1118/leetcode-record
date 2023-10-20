package test000;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Split {
  public static int minMaxSum(int[] nums, int k) {
    return backtrack(nums, 0, k, new int[k], 0, Integer.MAX_VALUE);
  }

  public static int backtrack(int[] nums, int start, int k, int[] sums, int maxSum, int minMaxSum) {
    if (start == nums.length) {
      if (k == 0) {
        for (int i = 0; i < k; i++) {
          maxSum = Math.max(maxSum, sums[i]);
        }
        minMaxSum = Math.min(minMaxSum, maxSum);
      }
      return minMaxSum;
    }

    for (int i = 0; i < k; i++) {
      sums[i] += nums[start];
      minMaxSum = backtrack(nums, start + 1, k, sums, maxSum, minMaxSum);
      sums[i] -= nums[start];
    }

    if (k < nums.length) {
      sums[k] = nums[start];
      minMaxSum = backtrack(nums, start + 1, k + 1, sums, maxSum, minMaxSum);
      sums[k] = 0;
    }

    return minMaxSum;
  }

  public static void main(String[] args) {
    int[] nums = {100, 200, 300, 400, 500};
    int k = 3;
    int result = minMaxSum(nums, k);
    System.out.println("最小的sum值是: " + result);
  }
}
