package test.round1;

import java.util.Arrays;

public class MinCostToRepairAllEdges {

    static int[] parentTracker;

    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] edgesToRepair = new int[][] {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
        System.out.println("Answer for Q1: " + minCostToRepairEdges(5, edges, edgesToRepair));
    }

    static int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair){

        parentTracker = new int[n+1];

        Arrays.fill (parentTracker,-1);
        Arrays.sort (edgesToRepair, (a,b) -> a[2] - b[2]);

        //Union connected edges first
        for(int[] edge: edges){
            if(!isBrokenEdge(edge, edgesToRepair)){
                if(findParent(edge[0]) !=findParent(edge[1])){
                    updateParent(edge[0],edge[1]);
                }
            }
        }

        int minCost = 0;

        //Union Broken Edges
        for(int[] repair:edgesToRepair){
            if(findParent (repair[0]) !=findParent (repair[1])){
                minCost +=repair[2];
                updateParent (repair[0],repair[1]);
            }
        }

        return minCost;
    }

    static boolean isBrokenEdge(int[] edge,int[][] edgesToRepair){
        for(int i=0; i<edgesToRepair.length;i++){
            if(edge[0]== edgesToRepair[i][0] && edge[1]== edgesToRepair[i][1])
                return true;
        }
        return false;
    }

    static void updateParent(int c1, int c2){
        int p1 = findParent (c1);
        int p2 = findParent (c2);
        parentTracker[p1] = p2;
    }

    static int findParent(int child){
        int parent = child;
        while (parentTracker[parent]>=0){
            parent = parentTracker[parent];
        }
        return parent;
    }

}
