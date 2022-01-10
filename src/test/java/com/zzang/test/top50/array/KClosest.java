package com.zzang.test.top50.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
//  public static void main(String[] args) {
//    List<List<Integer>> list = new ArrayList<List<Integer>>();
//
//    List<Integer> intList = new ArrayList<>();
//    List<Integer> intList2 = new ArrayList<>();
//    intList.add(1); intList.add(3);
//    intList2.add(-2); intList2.add(2);
//    list.add(intList);
//    list.add(intList2);
//
//    System.out.println(kClosest(list, 1));
//  }
//
//  public static int[][] convert(List<List<Integer>> list) {
//    int[][] array = new int[list.size()][];
//    for (int i = 0; i < array.length; i++) {
//      array[i] = new int[list.get(i).size()];
//    }
//    for(int i=0; i<list.size(); i++){
//      for (int j = 0; j < list.get(i).size(); j++) {
//        array[i][j] = list.get(i).get(j);
//      }
//    }
//    return array;
//  }

//  public static int[][] kClosest(List<List<Integer>> list, int K) {
//
//    int[][] points = convert(list);
//    int N = points.length;
//    int[] dists = new int[N];
//    for (int i = 0; i < N; ++i)
//      dists[i] = dist(points[i]);
//
//    Arrays.sort(dists);
//    int distK = dists[K-1];
//
//    int[][] ans = new int[K][2];
//    int t = 0;
//    for (int i = 0; i < N; ++i)
//      if (dist(points[i]) <= distK)
//        ans[t++] = points[i];
//    return ans;
//  }
//
//  public static int dist(int[] point) {
//    return point[0] * point[0] + point[1] * point[1];
//  }


  public static void main(String[] args) {
    KClosest a = new KClosest();
    int[][] points = { { 1, 3 }, { -2, 2 } };
    int k = 1;
//		int[][] points = {{3,3},{5,-1},{-2,4}};
//		int k =2;

    int[][] result = a.solve(points, k);
    a.print(result);
  }

  public int[][] solve(int[][] points, int k) {
    // 1. ds
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
    int[][] result = new int[k][2];

    // 2. for, while
    for (int[] p : points) {
      pq.offer(p);
    }
    int index = 0;
    while (index < k) {
      result[index] = pq.poll();
      index++;
    }
    return result;
  }

  public void print(int[][] result) {
    int m = result.length;
    int n = result[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
      }
      System.out.println();
    }
  }
}
