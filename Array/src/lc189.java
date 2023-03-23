package Array.src;

public class lc189 {
    public static void main(String[] args) {
        lc189 lc = new lc189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        int[] res = new int[7];
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        res = lc.reverse(nums,0, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1); // 7 6 5 4 3 2 1
            reverse(nums, 0, k - 1);           // 5 6 7 4 3 2 1
            reverse(nums, k, nums.length - 1); // 5 6 7 1 2 3 4
            
        }

        public int[] reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
            return  nums;
        }

}
