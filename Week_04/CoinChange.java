package week4;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/coin-change/description/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        //bfs(coins, amount);
        dp(coins, amount);
        return 0;
    }

    private int dp(int[] coins, int amount) {
        //https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
        //假设0....i
        //f[i] = f[i-1] + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    System.out.println(i + "_" + dp[i]);
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    System.out.println(i + "-" + coins[j] + "_" + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int bfs(int[] coins, int amount) {
        if (amount <= 0) return 0;
        Set<Integer> caches = new HashSet<>();
        //广度优先通过递减硬币来计算是否可以到达0，如果是负数说明不可以
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(amount);
        int level = 0;
        boolean find = false;
        TO:
        while (!queue.isEmpty()) {
            LinkedList<Integer> _queue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int currAmount = queue.poll();
                for (int i = 0; i < coins.length; i++) {
                    int _amount = currAmount - coins[i];
                    if (_amount > 0) {
                        if (!caches.contains(_amount)) {
                            caches.add(_amount);
                            _queue.addLast(_amount);
                        }
                    } else if (_amount == 0) {
                        find = true;
                        break TO;
                    }
                }
            }
            level++;
            queue = _queue;
        }
        return find ? level + 1 : -1;
    }

    public static void main(String[] args) {
        /*new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
        new CoinChange().coinChange(new int[]{2}, 3);*/
        System.out.println(9|0);
        System.out.println(9^0);
        System.out.println(~0);
        System.out.println(9^9);
        System.out.println(9^8^9);//交换两个数值
        System.out.println(9&(~0<<1));
    }
}
