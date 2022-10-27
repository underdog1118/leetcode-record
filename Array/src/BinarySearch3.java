package Array.src;
//lc34
public class BinarySearch3 {
    public static void main(String[] args) {
        BinarySearch3 l = new BinarySearch3();
        int[] nums = new int[]{1,2,3,4,5};
        int target = -5;
        int[] n = l.searchRange(nums,target);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }

    }
        public int find(int[] nums, int target){
            int left = -1;
            int right = nums.length;
            while (left + 1 != right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target){
                    left = mid;
                }else {
                    right = mid;
                }
            }return right;       //找最左侧值的函数
        }
        public int[] searchRange(int[] nums, int target) {
            int l = find(nums, target); //找target的最左侧值
            int r = find(nums, target + 1);  //找target+1的最左侧值， -1即为target最右

            if (l == nums.length || nums[l] != target) {   //不存在target， 返回 -1 , -1
                return new int[]{-1, -1};
            }
            return new int[]{l, r-1};
        }
    }


