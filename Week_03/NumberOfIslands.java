package week3;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    private int lands = 0;
    private int xLen = 0;
    private int yLen = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return lands;
        xLen = grid.length;
        yLen = grid[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1') {
                    lands++;
                    recursion(i, j, grid);
                }
            }
        }
        return lands;
    }

    private void recursion(int x, int y, char[][] grid) {
        //当发现是0或者到了边界则退出
        if (x < 0 || y < 0 || x >= xLen || y >= yLen || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        recursion(x + 1, y, grid);
        recursion(x, y + 1, grid);
        recursion(x - 1, y, grid);
        recursion(x, y - 1, grid);
    }

    public static void main(String[] args) {
        new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
    }
}
