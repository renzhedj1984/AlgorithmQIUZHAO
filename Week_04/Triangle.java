package week4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/triangle/description/
 */
public class Triangle {
    private Map<String, Integer> memorize = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int v = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + row.get(j);
                row.set(j, v);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        //https://leetcode-cn.com/problems/triangle/solution/shou-hua-tu-jie-dp-si-lu-120-san-jiao-xing-zui-xia/
        //https://leetcode-cn.com/problems/triangle/solution/san-chong-jie-fa-duo-tu-xiang-jie-120-san-jiao-xin/
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        List<Integer> bottomRow = triangle.get(n - 1);
        int[] dp = new int[bottomRow.size()];
        for (int i = 0; i < bottomRow.size(); i++) {
            dp[i] = bottomRow.get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        return recursion(0, 0, triangle);
    }

    public int recursion(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        Integer cache = memorize.get(i + "_" + j);
        if (cache == null) {
            int _j = recursion(i + 1, j, triangle);
            int _j_1 = recursion(i + 1, j + 1, triangle);
            int v = Math.min(_j, _j_1);
            memorize.put(i + "_" + j, v);
            return v + triangle.get(i).get(j);
        } else {
            return cache + triangle.get(i).get(j);
        }
    }

    public static void main(String[] args) {
        //类似Unique Paths
        /*
            2,0,0,0
            3,4,0,0
            6,5,7,0
            4,1,8,3
         */
        //假设第k层f(i,j) = min(f(i+1,j) , f(i+1,j+1)) + a[i,j]
        //这里需要一个思维转换不能自顶向下计算，而是要自底向上开始计算，尤其是求dp方程的时候是需要一个这样的思维转换的
        //这个题目自底向上计算是收敛的而自顶向下是扩散的需要判断边界的问题
    }
}
