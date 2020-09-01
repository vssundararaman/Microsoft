package test.round2;

public class DistanceBetweenNodesinBST {

    public static void main(String[] args) {

        int[] nums = {2,1,3};
        int node1 = 1;
        int node2 = 3;

        System.out.println (findDistance (nums,node1,node2));
    }

    /**
     * Solution
     * 1. Build BST
     * 2. Find LCA
     * 3. Find Distance between LCA to given Points
     */

    static int findDistance(int[] nums, int node1, int node2) {
        TreeNode root = null;

        // Step 1: Build BST
        for (int num : nums) {
            root = buildBST (root, num);
        }

        TreeNode LeastCommonAccessor = findLCA (root,node1, node2);
        int distance =  findDistanceFromLCA (LeastCommonAccessor, node1) + findDistanceFromLCA (LeastCommonAccessor, node2);
        return distance;
    }

    static int findDistanceFromLCA (TreeNode lca, int node1){
        int distance = 0;
        while(true){
            if(lca!=null){
                if(lca.val == node1){
                    return distance;
                }else if(lca.val > node1){
                    distance ++;
                    lca = lca.left;
                }else if(lca.val < node1){
                    distance ++;
                    lca = lca.right;
                }
            }else{
                return distance;
            }
        }
    }
    //Find the LeastCommonAccessor
    static TreeNode findLCA(TreeNode root, int node1, int node2){
        while(true){
            if(root.val < node1 && root.val < node2){
                return root.right;
            }else if(root.val> node1 && root.val > node2){
                return root.left;
            }else{
                return root;
            }
        }
    }

    static TreeNode buildBST(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode (num);
        } else if (root.val < num) {
            if (root.right == null) {
                root.right = new TreeNode (num);
            } else {
                buildBST (root.right, num);
            }
        } else if (root.val > num) {
            if (root.left == null) {
                root.left = new TreeNode (num);
            } else {
                buildBST (root.left, num);
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
