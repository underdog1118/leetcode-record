package Array.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        test lc = new test();
        int n = 3;
        int[] cost = {6410,3594,9382};
        int res = lc.minIncrements(n,cost);
        System.out.println(res);
    }


        public int minIncrements(int n, int[] cost) {
            int layers = (n-1)/2;
            int lens = (int) Math.pow (2,(layers-1));
            int[] lastLayer = new int[lens];
            int num = n;
            int max = 0;
            for (int i = lens-1; i >=0; i--, num--) {
                lastLayer[i] = cost[num-1];
                int k = num-1;
                while (k != 0) {
                    if (k % 2 == 0) {
                        k = (k-2)/2;
                        lastLayer[i] += cost[k];
                    } else {
                        k = (k-1)/2;
                        lastLayer[i] += cost[k];
                    }
                }
                max = Math.max(max, lastLayer[i]);
            }

            for (int i = 0; i < lens; i++) {
                lastLayer[i] = max - lastLayer[i];
            }
            int cnt = 0;
            for (int i = 0; i < lens-1; i+=2) {
                cnt += Math.max(lastLayer[i],lastLayer[i+1]);
            }
            return cnt;

        }


}

