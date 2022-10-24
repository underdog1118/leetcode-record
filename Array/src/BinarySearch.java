package Array.src;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch l = new BinarySearch();
        int[] nums = new int[]{1, 2, 3, 5, 5, 5, 8, 9};
        int target = 5;
        int k = l.left_bound(nums, target);
        int m = l.right_bound(nums, target);
        System.out.println(k);
        System.out.println(m);
        }

    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;   //左闭右开，把空间往右边压缩找到最右侧元素
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left - 1; //压缩到右侧最后一个元素的右边一位（left-right) ,-1返回 index
    }

}
