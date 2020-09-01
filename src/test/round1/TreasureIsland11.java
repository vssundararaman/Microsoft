package test.round1;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland11 {

    public static void main(String[] args) {

    }

    static int shortestPathToTreasureIsland(char[][] grid){
        if(grid == null || grid.length ==0) return 0;
        int row = grid.length, col=grid[0].length, minStep = Integer.MAX_VALUE;
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='S'){
                    minStep = Math.min (minStep,bfs(grid, i,j));
                }
            }
        }
        return minStep;
    }

    private static int bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<> ();
        queue.offer (new int[]{row,col});
        int steps = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty ()){
            int size = queue.size ();
            while(size>0){
                int[] coor = queue.poll ();
                int x = coor[0], y = coor[1];
                if(grid[x][y]=='X') return steps;
                visited[x][y]=true;

                for(int i=0; i< directions.length;i++){
                    int dx = x+directions[i][0];
                    int dy = y+directions[i][1];

                    if(dx>=0 && dx< grid.length && dy>=0 && dy< grid.length
                    && !visited[dx][dy] && grid[dx][dy]!='D'){
                        queue.offer (new int[]{dx,dy});
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}
