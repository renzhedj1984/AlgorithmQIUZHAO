package week4;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        //O[m*n]时间复杂度
        //O[m*n]空间复杂度
        int[][] dp = new int[m][n];//设定边界x,y轴索引0的位置都为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;//当长度or宽度都为1情况下只有一种路径
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        //https://leetcode-cn.com/problems/unique-paths/solution/tu-jie-miao-dong-fen-xi-guo-cheng-by-zi-gei-zi-zu/
        //O[m*n]时间复杂度
        //O[m]空间复杂度
        int[] dp = new int[m];
        Arrays.fill(dp, 1);//初始化
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        //假设有m*n个格子,
        // 0......i <= m
        // 0......j <= n
        // f[i][j]值为第i,j的格子可以走的总和 f[i][j] = f[i-1][j] + f[i][j-1]
        // f[0][0] = 1
        // f[i][0.....j] = f[i][j-1] or f[0....i][j] = f[i-1][j]
        // f[0][0] = 1 f[0][1]=f[0][1-1] = 1 当方格子为一个长度或者宽度都为1的情况
        // 可以向下向右走一步,当不改变方向的时候算为一种方法
        // 当下一步改变方向时方法+1，且f(i,j)等于f(i-1,j)+f(i,j-1)的和
        new UniquePaths().uniquePaths2(4, 4);
    }
}
