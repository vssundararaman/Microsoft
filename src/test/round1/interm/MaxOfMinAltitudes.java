package test.round1.interm;

public class MaxOfMinAltitudes {

    /**
     * Aug/06/2020
     * Amazon | OA 2019 | Max Of Min Altitudes
     * https://leetcode.com/discuss/interview-question/383669/
     */

    public static int getMaxScore(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length, maxScore = Integer.MIN_VALUE;
        int[][] maxMin = new int[m][n];
        maxMin[0][0] = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) maxMin[i][0] = Math.min(grid[i][0], maxMin[i-1][0]);

        for (int j = 1; j < n; j++) maxMin[0][j] = Math.min(grid[0][j], maxMin[0][j-1]);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int upper = Math.min(grid[i][j], maxMin[i - 1][j]);
                int left = Math.min(grid[i][j], maxMin[i][j - 1]);
                maxMin[i][j] = Math.max(upper, left);
            }
        }

        return Math.max(maxMin[m-1][n-2], maxMin[m-2][n-1]);
    }

    public static void test(int[][] grid, int expected) {
        System.out.println(getMaxScore((grid)) == expected);
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][] { { 5, 1 }, { 4, 5 } };
        int[][] grid2 = new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } };
        int[][] grid3 = new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } };

        test(grid1, 4);
        test(grid2, 4);
        test(grid3, 4);
    }
}
