package test.round1;

public class DistanceBetweenNodesInBST {

    public static void main(String[] args) {
        int[] num = {2,1,3};

        System.out.println (findDistance (num, 1,3));

    }

    static int findDistance(int[] nums, int node1, int node2) {
        TreeNode root = null;

        for (int i = 0; i < nums.length; i++) {
            root = buildBST (root, nums[i]);
        }

        TreeNode lca = findLeastCommonAncestor (root, node1, node2);
        int distance = findDistanceFromLCA (lca, node1) + findDistanceFromLCA (lca, node2);
        return distance;
    }

    private static int findDistanceFromLCA(TreeNode lca, int node1) {
        int distanceSum = 0;
        while (true) {
            if (lca != null) {
                if (lca.val == node1) {
                    return distanceSum;
                } else if (lca.val < node1) {
                    distanceSum++;
                    lca = lca.right;
                } else if (lca.val > node1) {
                    distanceSum++;
                    lca = lca.left;
                }
            } else {
                return distanceSum;
            }
        }
    }

    private static TreeNode findLeastCommonAncestor(TreeNode root, int node1, int node2) {

        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    static TreeNode buildBST(TreeNode root, int node) {

        if (root == null) {
            root = new TreeNode (node);
        } else if (root.val < node) {
            if (root.right == null) {
                root.right = new TreeNode (node);
            } else {
                buildBST (root.right, node);
            }
        } else if (root.val > node) {
            if (root.left == null) {
                root.left = new TreeNode (node);
            } else {
                buildBST (root.left, node);
            }
        }
        return root;
    }
}
