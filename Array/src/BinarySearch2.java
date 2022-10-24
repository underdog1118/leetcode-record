package Array.src;

public class BinarySearch2 {
    public static void main(String[] args) {
        BinarySearch2 l = new BinarySearch2();
        int[] nums = new int[]{1, 2, 3, 5, 5, 5, 8, 9};
        int target = 5;
        int n = l.find(nums,target);
        int k = l.left_bound(nums, target);
        int m = l.right_bound(nums, target);
        System.out.println(n);
        System.out.println(k);
        System.out.println(m);
    }

    int find(int[] nums, int target){
        int left = -1;
        int right = nums.length; //左开右开
        while (left + 1 != right){
            int mid = left + (right - left) / 2; //avoid overflow
            if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] == target){
                return mid; //找到直接返回该数值
            }
        }return left;
    }


    int left_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 != right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] == target){
                right = mid; //找左极限， 得到target时候令right = mid, 把区间往左边压
            }
        }return right;

    }

    int right_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] == target){
                left = mid;  //找到target时候，把区间往右侧压缩， 找最右侧=target的元素
            }
        }
        return left;
    }

}
