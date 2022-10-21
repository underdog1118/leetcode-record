package Array.src;

public class lc {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        for(int i = 3; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
        for(int i = 0; i < nums.length - 1; i++){
            System.out.println(nums[i]);
        }

    }
}
