package com.zzang.test.top50.array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
  public static void main(String[] args) {
    MeetingRooms a = new MeetingRooms();


    Interval in1 = new Interval(15,20);
    Interval in2 = new Interval(5,10);
    Interval in3 = new Interval(25,30);

    Interval[] intervals = {in1, in2,in3};
    System.out.println(a.solve(intervals));
  }


  public boolean solve(Interval[] intervals) {

    Arrays.sort(intervals, (a, b) -> a.start - b.start);

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i-1].end >= intervals[i].start) {
        return false;
      }
    }

    return true;
  }












//  public boolean solve(Interval[] intervals) {
//    if(intervals == null) return false;
//    //1 sorting
//    print(intervals);
//    Arrays.sort(intervals, Comp);
//    System.out.println("===after sort====");
//    print(intervals);
//
//    for(int i=1; i<intervals.length; i++) {
//      if(intervals[i-1].end >intervals[i].start)
//        return false;
//    }
//
//    return true;
//
//
//  }
//  public void print(Interval[] intervals) {
//    for(int i=0; i<intervals.length; i++) {
//      Interval in = intervals[i];
//      System.out.println(in.start+" "+in.end);
//
//    }
//  }
//  Comparator<Interval> Comp = new Comparator<Interval>() {
//
//    @Override
//    public int compare(Interval a, Interval b) {
//      // TODO Auto-generated method stub
//      return a.start - b.start;
//    }
//
//  };
}
