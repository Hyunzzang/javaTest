package com.zzang.test.top50.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(solve(matrix));
  }

  public static List<Integer> solve(int[][] matrix) {
    // 1
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    int rowStart = 0;
    int rowEnd = matrix.length - 1;

    int colStart = 0;
    int colEnd = matrix[0].length - 1;

    //
    while (rowStart <= rowEnd && colStart <= colEnd) {
      // right
      for (int i = colStart; i <= colEnd; i++) {
        result.add(matrix[rowStart][i]);
      }
      rowStart++;
      // down
      for (int i = rowStart; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;

      // left 3->0
      if (rowStart <= rowEnd) {
        for (int i = colEnd; i >= colStart; i--) {
          result.add(matrix[rowEnd][i]);
        }
      }
      rowEnd--;
      // up 2->1
      if (colStart <= colEnd) {
        if (rowStart <= rowEnd) {
          for (int i = rowEnd; i >= rowStart; i--) {
            result.add(matrix[i][colStart]);
          }
        }
      }
      colStart++;
    }
    return result;
  }

  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    if(matrix==null || matrix.length==0)
      return new ArrayList<Integer>();

    return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
  }

  public ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
    ArrayList<Integer> result = new ArrayList<Integer>();

    if (m <= 0 || n <= 0) {
      return result;
    }

    //only one element left
    if (m == 1 && n == 1) {
      result.add(matrix[x][y]);
      return result;
    }

    //top - move right
    for (int i = 0; i < n - 1; i++) {
      result.add(matrix[x][y++]);
    }

    //right - move down
    for (int i = 0; i < m - 1; i++) {
      result.add(matrix[x++][y]);
    }

    //bottom - move left
    if (m > 1) {
      for (int i = 0; i < n - 1; i++) {
        result.add(matrix[x][y--]);
      }
    }

    //left - move up
    if (n > 1) {
      for (int i = 0; i < m - 1; i++) {
        result.add(matrix[x--][y]);
      }
    }

    if (m == 1 || n == 1) {
      result.addAll(spiralOrder(matrix, x, y, 1, 1));
    } else {
      result.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));
    }

    return result;
  }
}
