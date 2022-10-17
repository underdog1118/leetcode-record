package Array.src;

import static java.util.Arrays.sort;

//27. Remove Element
public class lc27 {
    public static void main(String[] args) {
        lc27 lc = new lc27();
        int[] a = new int[]{2,3,5,7,2,54,3,2};
        System.out.println(lc.removeElement(a,2));
        for (int i = 0; i < lc.removeElement(a,2); i++) {
            System.out.println(a[i]);
        }

        System.out.println("---------------");

        System.out.println(lc.removeElement2(a,2));
        for (int i = 0; i < lc.removeElement2(a,2); i++) {
            System.out.println(a[i]);
        }
    }
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < k; i++) {
            if (nums[i] == val) {
                for (int j = i; j < k - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;  //索引减1再走一遍
                k--;  //数组大小减1
            }
        }
        return k;
    }


        public int removeElement2(int[] nums2, int val2) {
            int slowIndex = 0;   //快慢双指针 快指针：寻找新数组元素 慢指针：更新新数组下标
            int k = nums2.length;
            for(int fastIndex = 0; fastIndex < k; fastIndex++){
                if(nums2[fastIndex] != val2){
                    nums2[slowIndex] = nums2[fastIndex];
                    slowIndex++;
                }
            }return slowIndex;
        }
    }






