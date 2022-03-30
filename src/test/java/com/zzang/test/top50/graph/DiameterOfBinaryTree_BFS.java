package com.zzang.test.top50.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 */
public class DiameterOfBinaryTree_BFS {

    public static void main(String[] args) {
        DiameterOfBinaryTree_BFS a = new DiameterOfBinaryTree_BFS();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

//        System.out.println("val: " + a.bfs(node));

        System.out.println("val: " + a.diameterOfBinaryTree(node));
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maxDiameter;
    }

    private int getDiameter(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = getDiameter(node.left);
        int rightHeight = getDiameter(node.right);
        maxDiameter = Math.max(maxDiameter ,rightHeight+leftHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;

    }
}
