package Array.src;

import java.util.Arrays;

public class lc719 {
    public static void main(String[] args) {
        lc719 lc = new lc719();
        int[] nums = new int[]{1, 2, 3, 4, 5, 1};

        int res = lc.smallestDistancePair(nums, 10);
        System.out.println(res);
    }

    public int smallestDistancePair(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        //找到左右取值范围
        int left = 0, right = nums[n - 1] - nums[0];
        //二分找第K小
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = 0;
            int count = 0;
            //计算当前小于mid的数对有多少
            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            //count小于则left = mid + 1，
            // 大于则right = mid - 1
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
