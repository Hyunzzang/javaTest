package com.zzang.test.top50.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth a = new MaxDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(a.solve(root));
    }

    int max = 0;

    public int solve(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
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

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println("node: " + node.val);
            int count = value.pop();
            max = Math.max(max, count);
            if (node.left != null) {
                stack.push(node.left);
                value.push(count + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(count + 1);
            }
        }
        return max;
    }

}
