package Array.src;

public class lc485 {
    public static void main(String[] args) {
        lc485 lc = new lc485();
        int[] a = new int[]{1,1,0,1,1,1,0,1,1,1,1,0};
        System.out.println(lc.findMaxConsecutiveOnes(a));
    }
        public int findMaxConsecutiveOnes(int[] nums) {
                int count = 0;
                int max = 0;
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == 1){
                        count ++;
                        max = Math.max(count, max);  //得到max和count中的较大值
                    }
                    else{
                        count = 0;
                    }
                }
                return max;
            }
        }


