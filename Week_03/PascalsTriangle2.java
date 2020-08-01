package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii
 */
public class PascalsTriangle2 {
    private Map<String, Integer> cache = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {
        return recursionSolution(rowIndex);
    }

    private List<Integer> stackSolution(int rowIndex) {
        return null;
    }

    private List<Integer> recursionSolution(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0 || i == rowIndex) {
                row.add(1);
            } else {
                //上标 i-1 if 0 = 1     i if
                row.add(getCell(rowIndex, i));
            }
        }
        return row;
    }

    private int getCell(int rowIndex, int cellIndex) {
        if (cellIndex == 0 || rowIndex == cellIndex) {
            return 1;
        }
        String key = rowIndex + "_" + cellIndex;
        if (cache.get(key) != null) {
            return cache.get(key);
        }
        int value = getCell(rowIndex - 1, cellIndex - 1) + getCell(rowIndex - 1, cellIndex);
        cache.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        new PascalsTriangle2().getRow(5);
    }
}
