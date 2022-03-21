package com.zzang.test.top50.graph;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water. The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxOfIsland_bfs {

    public static void main(String[] args) {

        int[][] grid =
            {{1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}};
        MaxOfIsland_bfs a = new MaxOfIsland_bfs();
        System.out.println(a.maxAreaOfIsland(grid));
    }


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, m, n, 0);
                    System.out.println("area: " + area);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j, int m, int n, int area) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return area;
        }
        grid[i][j] = 0;
        area++;
        area = dfs(grid, i + 1, j, m, n, area);
        area = dfs(grid, i, j + 1, m, n, area);
        area = dfs(grid, i - 1, j, m, n, area);
        area = dfs(grid, i, j - 1, m, n, area);
        return area;
    }
}
