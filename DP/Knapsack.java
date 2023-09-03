package DP;

public class Knapsack {

  public static void main(String[] args) {
    int N = 3; //3个物品
    int[] weight = {2,1,3}; //重量
    int[] val = {4,2,3}; //价值
    int W = 4; //装进4kg的容量的背包

    //求最大价值
    System.out.println(findMax(N,W, weight, val));
  }

  public static int findMax(int N, int W, int[] weight, int[] val) {
    int[][] dp = new int[N+1][W+1]; // dp[i][j] : j容量的背包装i个物品所能得到的最大val
    for (int i = 1; i <= N; i++) {
      for (int w = 1; w <= W; w++) {
        if (w - weight[i-1] < 0) {
          dp[i][w] = dp[i-1][w]; //已经装不下了，等于前一个
        } else {
          dp[i][w] = Math.max(dp[i-1][w],  //没有装当前i的物品，自然等于装了i-1个的最大Val
                              dp[i-1][w-weight[i-1]] + val[i-1]); //装当前i，则前一个只能装w-当前i重量的值 + 当前的价值
        }
      }
    }
    return dp[N][W]; //装N个物品的容量为W的背包的最大Val
  }
}
