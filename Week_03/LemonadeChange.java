package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LemonadeChange {
    private List<Integer> coins = new ArrayList<>();

    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) return false;
        if (bills[0] > 5) return false;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                coins.add(5);
                continue;
            }
            int ret = bill - 5;
            if (findCoin(ret, new LinkedList<>())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean findCoin(int ret, LinkedList<Integer> rets) {
        int sum = 0;
        for (int coin : rets) {
            sum += coin;
        }
        if (sum == ret)
            return true;
        for (int i = 0; i < coins.size(); i++) {
            rets.add(coins.get(i));
            findCoin(ret, rets);
            rets.removeLast();
        }
        return false;
    }

    public static void main(String[] args) {
        new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 10, 20, 20});
    }
}
