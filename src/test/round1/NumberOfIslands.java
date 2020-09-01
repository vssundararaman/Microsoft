package test.round1;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] island =
                {{'1','1','0','1','0'},
                 {'1','1','0','1','0'},
                 {'1','1','0','0','0'},
                 {'0','0','1','0','1'}};

        System.out.println (numOfIslands (island));
    }

    static int numOfIslands(char[][] grid) {

        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands += findIsLands (grid, i, j);
                }
            }
        }
        return numOfIslands;
    }

    static int findIsLands(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        findIsLands (grid, i - 1, j);
        findIsLands (grid, i + 1, j);
        findIsLands (grid, i, j + 1);
        findIsLands (grid, i, j - 1);
        return 1;
    }
}
