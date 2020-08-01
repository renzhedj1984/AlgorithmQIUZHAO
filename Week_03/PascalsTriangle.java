package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    private List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        arraySolution(numRows);
        return res;
    }

    private void recursionSolution(int numRows) {

    }

    private void arraySolution(int numRows) {
        /*
        1.先初始化数组
        2.元素赋值
        3.数组赋值中间变量
         */
        List<Integer> prev = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    rows.add(1);
                } else {
                    rows.add(prev.get(j - 1) + prev.get(j));
                }
            }
            res.add(rows);
            prev = rows;
        }

    }


    public static void main(String[] args) {
        new PascalsTriangle().generate(5);
    }
}
