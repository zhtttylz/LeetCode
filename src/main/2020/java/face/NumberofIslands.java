package face;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * @author zhtttylz
 * @date 2020/11/23 23:48
 * 染色扩散
 */
public class NumberofIslands {

    int[][] road = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        // 访问过标记为true
        boolean[][] help = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                // 如果一个节点没有被访问过，并且是个陆地
                if (grid[i][j] == '1' && !help[i][j]) {

                    res++;
                    // 将这个节点相邻的所有1都标记为访问过
                    help(i, j, grid, help);
                }
            }
        }
        return res;
    }

    private void help(int i, int j, char[][] grid, boolean[][] help) {
        if (grid[i][j] == '0' || help[i][j]) {
            return;
        } else {
            help[i][j] = true;
            for (int a = 0; a < road.length; a++) {

                int i_tmp = i + road[a][0];
                int j_tmp = j + road[a][1];
                if (i_tmp < 0 || i_tmp >= grid.length || j_tmp < 0 || j_tmp >= grid[0].length) continue;
                help(i_tmp, j_tmp, grid, help);
            }
        }
    }

    public static void main(String[] args) {

        NumberofIslands n = new NumberofIslands();
        System.out.println(n.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}
