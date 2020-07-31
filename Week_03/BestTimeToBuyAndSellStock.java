package week3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/c-li-yong-shao-bing-wei-hu-yi-ge-dan-diao-zhan-tu-/
        int profit = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        prices = Arrays.copyOf(prices, prices.length + 1);
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && price < stack.peek()) {
                int head = stack.pop();
                if (stack.size() > 0) {
                    profit = Math.max(profit, head - stack.peekLast());
                }
            }
            stack.push(price);
        }
        return profit;
    }

    public int maxProfit3(int[] prices) {
        if (prices.length == 0)
            return 0;
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/c-li-yong-shao-bing-wei-hu-yi-ge-dan-diao-zhan-tu-/
        int profit = 0;
        int minPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (i == 0 || minPrice > price) {
                minPrice = price;
            } else {
                profit = Math.max(profit, price - minPrice);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().maxProfit3(new int[]{7, 1, 5, 3, 6, 4});
    }
}
