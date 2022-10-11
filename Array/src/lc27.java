import static java.util.Arrays.sort;

public class lc27 {
    public int removeElement(int[] nums, int val) {
            int k = nums.length;
            for(int i = 0; i < k; i++){
                if(nums[i] == val){
                    for(int j = i; j < k-1; j++){
                        nums[j] = nums[j+1];
                    }
                    i --;  //索引减1再走一遍
                    k --;  //数组大小减1
                }
            }return k;
    }

}


