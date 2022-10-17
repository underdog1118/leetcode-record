package Array.src;

public class lc35 {
    public static void main(String[] args) {
        System.out.println(3/2);
    }
    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;

        while(left + 1 != right){
            int mid = (left + right)/2;
            if((mid < target)){
                left = mid;
            }else if(mid > target){
                right = mid;
            }else if(mid == target){
                return mid;
            }
        }return right;
    }
}
