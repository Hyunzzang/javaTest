package com.zzang.test.top50.graph;

import java.util.Stack;

public class DiameterOfBinaryTree_DFS {

    public static void main(String[] args) {
        DiameterOfBinaryTree_DFS a = new DiameterOfBinaryTree_DFS();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
//        node.left.right.left = new TreeNode(6);
//        node.left.right.right = new TreeNode(7);

//    System.out.println("val: "+a.dfs(node));
        System.out.println("val: " + a.diameterOfBinaryTree(node));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int max = 0;
        stack.push(root);
        countStack.push(1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = countStack.pop();
            max = Math.max(max, count);

            if (node.left != null) {
                stack.push(node.left);
                countStack.push(count+1);
            }
            if (node.right != null) {
                stack.push(node.right);
                countStack.push(count+1);
            }
        }

        return max;
    }


    int max = 0;
    public int diameterOfBinaryTree_2(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode node){
        if(node == null){return 0;}
        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(left+right, max);
        return Math.max(left,right)+1;
    }
}
