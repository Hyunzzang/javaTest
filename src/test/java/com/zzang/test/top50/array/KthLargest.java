package com.zzang.test.top50.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
  public static void main(String[] args) {
    KthLargest a = new KthLargest();
    int[] nums = {3,2,1,5,6,4};
    int k =2;
    System.out.println(a.solve(nums , k));
    System.out.println(a.solve_pq(nums , k));
  }
  public int solve(int[] nums , int k) {
    int n = nums.length;
    Arrays.sort(nums);
    print(nums);
    return nums[n-k];
  }
  public void print(int[] nums) {
    for(int i:nums)
      System.out.println("i "+i);
  }

  public int solve_pq(int[] nums , int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> a-b);

    for(int val : nums) {
      pq.offer(val);
      if(pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();


  }
  Comparator<Integer> Comp = new Comparator<Integer>() {

    @Override
    public int compare(Integer a, Integer b) {
      // TODO Auto-generated method stub
      return a-b;
    }

  };
}
