package com.amazon.codechallenge;

import java.util.*;

// "static void main" must be defined in a public class.
public class ZombieSpread {
    public static void main(String[] args) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>> ();
        list.add(Arrays.asList(0, 1, 1, 0, 1));
        list.add(Arrays.asList(0, 1, 0, 1, 0));
        list.add(Arrays.asList(0, 0, 0, 0, 1));
        list.add(Arrays.asList(0, 1, 0, 0, 0));
        ZombieSpread z = new ZombieSpread();
        int result = z.calculateHours(list);
        System.out.println(result);
    }

    public int calculateHours(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        Queue<int[]> q = new LinkedList<> ();

        int target = m * n; // toal no of zombies
        int zombies = 0, hours = 0;

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[] {i,j});
                    zombies++;
                }

        while(!q.isEmpty()) {
            int size = q.size();
            if(zombies == target) return hours; // when all are zombies

            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int[] d : dirs) {
                    // check neighbours
                    int newRow = cur[0] + d[0];
                    int newCol = cur[1] + d[1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid.get(newRow).get(newCol) == 1) continue;

                    zombies++;
                    q.offer(new int[] {newRow, newCol});
                    grid.get(newRow).set(newCol, 1);
                }
            }
            hours++;
        }
        return -1;
    }
}