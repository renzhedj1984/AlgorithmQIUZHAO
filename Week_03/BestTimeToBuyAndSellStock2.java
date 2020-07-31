package week3;


public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        //1 定义最小点和最大点  假设0是最小1是最大
        // 当前值 如果与最小比较 是最小 替换  如果是大于最大替换
        //  如果遇到最大大于当前值  计算收益
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            } else {
                int subProfit = price - min;
                
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock2().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
