package com.zzang.test.top50.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상정렬
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You
 * are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int course = 5;
        int[][] nums = {{1, 0},
            {2, 1},
            {4, 3},
            {3, 2}};

        int[][] nums2 = {{1, 0},
            {0, 1}};

//		int[][] nums2 = {
//				 { 1, 2 },
//		         { 3, 1 },
//		         { 2, 3 } };

        CourseSchedule a = new CourseSchedule();
        System.out.println(a.solve(course, nums));
//    System.out.println(a.canFinish(course, nums));
    }

    public boolean solve(int courseNumber, int[][] nums) {
        if (courseNumber <= 0) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        // 1. inDegree : [1, 1, 1, 0]
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]]++;
        }

        // 2.queue에 0인 값 찾아서 넣기
        int completeLength = inDegree.length;
        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3.
        while (!queue.isEmpty()) {
            int zeroVal = queue.poll();
            for (int i = 0; i < numsLength; i++) {
                System.out.println("=============");
                if (zeroVal == nums[i][0]) {
                    System.out.println("zeroVal " + zeroVal + " i " + i);
                    inDegree[nums[i][1]]--;
                    if (inDegree[nums[i][1]] == 0) {
                        queue.offer(nums[i][1]);
                    }
                }
            }
        }

        /*
         *  4. 3번에서 completed에 값을 0으로 다 만들어야
         *  완성completed[nums[i][1]]--
         */

        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i, tmp, size = prerequisites.length;
        int[] counter = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();

        for (i = 0; i < size; i++) {
            int prerVal = prerequisites[i][0];
            counter[prerVal]++;
        }
        for (i = 0; i < numCourses; i++) {
            if (counter[i] == 0) {
                q.add(i);
            }
        }
        int num = q.size();

        while (!q.isEmpty()) {
            tmp = q.remove();

            for (i = 0; i < size; i++) {
                if (prerequisites[i][1] == tmp) {
                    counter[prerequisites[i][0]]--;
                    if (counter[prerequisites[i][0]] == 0) {
                        num++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return num == numCourses;
    }
}
