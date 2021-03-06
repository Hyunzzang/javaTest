package com.zzang.test.top50.dynamic;

public class UniquePath {
  public static void main(String[] args) {
    int m =7, n=3;
    System.out.println(uniquePaths(m, n));
  }
  public static int uniquePaths(int m, int n) {
    Integer[][] map = new Integer[m][n];
    for(int i = 0; i<m;i++){
      map[i][0] = 1;
    }
    for(int j= 0;j<n;j++){
      map[0][j]=1;
    }
    for(int i = 1;i<m;i++){
      for(int j = 1;j<n;j++){

        map[i][j] = map[i-1][j]+map[i][j-1];
        System.out.println("map["+i+"]["+j+"] "+map[i][j]);
      }
    }
    return map[m-1][n-1];
  }

  public int uniquePaths2(int m, int n) {
    int[][] area = new int[n][m];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(i==0 || j == 0) area[i][j] = 1;
        else area[i][j] = area[i-1][j] + area[i][j-1];
      }
    }
    return area[n-1][m-1];
  }


}
