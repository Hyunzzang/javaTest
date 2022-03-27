package com.zzang.test.top50.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Interval {

    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        queue.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (queue.peek()[1] >= intervals[i][0]) {
                int[] val = queue.poll();
                if (val[1] < intervals[i][1]) {
                    val[1] = intervals[i][1];
                }
                queue.offer(val);
            } else {
                queue.offer(intervals[i]);
            }
        }

        int[][] result = new int[queue.size()][2];
        for (int i = 0; i < result.length; i++) {
            int[] val = queue.poll();
            result[i] = val;
        }
        Arrays.sort(result, (a, b) -> a[0] - b[0]);

        return result;
    }

    public static void main(String[] args) {
//    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] intervals = {{1, 4}, {2, 3}};

        MergeInterval mergeInterval = new MergeInterval();
        int[][] res = mergeInterval.merge(intervals);

        System.out.println("res: " + Arrays.stream(res).map(arr -> Arrays.toString(arr))
            .collect(Collectors.joining(",")));
    }
}

//public class MergeInterval {
//  public static void main(String[] args) {
//
////			int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
//    Interval in1 = new Interval(1, 3);
//    Interval in2 = new Interval(2, 6);
//    Interval in3 = new Interval(8, 10);
//    Interval in4 = new Interval(15, 18);
//
//    List<Interval> intervals = new ArrayList<>();
//    intervals.add(in1);
//    intervals.add(in2);
//    intervals.add(in3);
//    intervals.add(in4);
//    MergeInterval a = new MergeInterval();
//    List<Interval> list = a.merge(intervals);
//    a.print(list);
//  }
//
//  public List<Interval> merge(List<Interval> intervals) {
//    if (intervals.isEmpty())
//      return intervals;
//
//    //type1
////		Collections.sort(intervals,(a,b) -> a.start-b.start);
//    //type2
//    Collections.sort(intervals, comp2);
//
//
//    List<Interval> result = new ArrayList<Interval>();
//    Interval before = intervals.get(0);
//    for (int i = 1; i < intervals.size(); i++) {
//      Interval current = intervals.get(i);
//      if (before.end >= current.start) {
//        before.end = Math.max(current.end, before.end);
//      } else {
//        result.add(before);
//        before = current;
//      }
//    }
//
//    if (!result.contains(before)) {
//      System.out.println("before.end: " + before.end);
//      result.add(before);
//    }
//
//    return result;
//  }
//
//  //type2
//  Comparator comp = new Comparator<Interval>() {
//    public int compare(Interval a, Interval b) {
//      // TODO Auto-generated method stub
//      return a.start - b.start;
//    }
//  };
//
//  //type3
//  Comparator<Interval> comp2 = new Comparator<Interval>() {
//    @Override
//
//    public int compare(Interval o1, Interval o2) {
//      if (o1.start > o2.start) {
//        return 1;
//      } else if (o1.start < o2.start) {
//        return -1;
//      } else {
//        return 0;
//      }
//    }
//  };
//
//  void print(List<Interval> list) {
//    for (int i = 0; i < list.size(); i++) {
//      Interval in = list.get(i);
//      System.out.println(in.start + " " + in.end);
//    }
//  }
//
//}
