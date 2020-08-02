package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Nqueens {
    private LinkedList<List<String>> res = new LinkedList<>();

    private LinkedList<Integer> cols = new LinkedList<>();//每行列的索引

    private LinkedList<Integer> xyDifs = new LinkedList<>();//x-y 常数左对角线

    private LinkedList<Integer> xySums = new LinkedList<>();//x+y 常数右对角线

    public List<List<String>> solveNQueens(int n) {
        //很多题目目的是二维或者多维转一维通过while loop 或者 recursion解决
        recursion(n, 0);
        return res;
    }

    private void recursion(int n, int row) {
        if (cols.size() == n) {
            buildArrays(new ArrayList<>(cols));
            return;
        }
        for (int col = 0; col < n; col++) {
            int xyDif = row - col;
            int xySum = row + col;
            if (cols.contains(col) || xyDifs.contains(xyDif) || xySums.contains(xySum)) {
                continue;
            }
            cols.add(col);
            xyDifs.add(xyDif);//更新左对角线
            xySums.add(xySum);//更新右对角线
            recursion(n, row + 1);
            cols.removeLast();
            xyDifs.removeLast();//更新左对角线
            xySums.removeLast();//更新右对角线
        }
    }

    private void buildArrays(List<Integer> cols) {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            int col = cols.get(i);
            StringBuilder rowStr = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                if (j != col) {
                    rowStr.append(".");
                } else {
                    rowStr.append("Q");
                }
            }
            rows.add(rowStr.toString());
        }
        res.add(rows);
    }

    public static void main(String[] args) {
        new Nqueens().solveNQueens(8);
    }
}
