package com.microsoft.design;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBST {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode (4);

        tree.left = new TreeNode (2);
        tree.right = new TreeNode (5);
        tree.left.left = new TreeNode (1);
        tree.right.right = new TreeNode (8);

        System.out.println (" **** " + serialise (tree));
    }

    static String serialise(TreeNode root) {

        List<String> list = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<> ();

        queue.offer (root);

        while(!queue.isEmpty ()){
            TreeNode node = queue.poll ();
            if(node ==null){
                list.add ("#");
            }else{
                list.add("" + node.val);
                queue.offer (node.left);
                queue.offer (node.right);
            }
        }

        System.out.println (list);
        return String.join ("," + " TESTDATA "+ list);
    }
}
