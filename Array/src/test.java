package Array.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        test lc = new test();
        int[] nums = new int[]{1,-10,7,13,6,8};
        int value = 5;
        for (int n : nums){
            while (n > 0 && n-value > 0) {
                n-=value;
            }
            while (n < 0) {
                n+= value;
            }
        }
        System.out.println((-3)%4);
    }





}

