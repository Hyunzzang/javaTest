package com.zzang.test.top50.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid
 * parentheses to make the input string valid.
 * <p>
 * Return all the possible results. You may return the answer in any order.
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String s = "(a)())()";
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.solve(s));
    }

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> exist = new HashSet<>();
        List<String> list = new ArrayList<>();
        // 이미 해당 순서에서 답을 찾았으면 더는 제거 안하도록
        boolean notFound = true;
        // 체크할 대상인 큐에 넣고, 중복체크할 Set에도 넣어준다
        queue.offer(s);
        exist.add(s);
        // BFS 시행
        while (!queue.isEmpty() && notFound) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String check = queue.poll();
                // 올바른 괄호 체크, 찾으면 true, 리스트에 정답 넣기
                if (isValid(check)) {
                    notFound = false;
                    list.add(check);
                }
                // 한글자씩 제거한 문자열 재생성해서 중복 아니면 Set와 Queue에 넣기
                // 앞에서 최초 정답 찾았으면 더이상 제거한 단어 재생산 필요 없으므로 중단
                for (int j = 0; j < check.length() && notFound; j++) {
                    String newWord = check.substring(0, j) + check.substring(j+1);
                    if (!exist.contains(newWord)) {
                        exist.add(newWord);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return list;
    }

    public List<String> solve(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    found = true;
                    System.out.println("str: " + str + " found " + found);
                }
                System.out.println("found " + found);
                if (found) {
                    continue;
                }
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') {
                        continue;
                    }
                    System.out.println(str.substring(0, j) + ":" + str.substring(j + 1));
                    String newStr = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(newStr)) {
//						System.out.println("newStr: "+newStr);
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
                System.out.println("======");
            }
        }
        return result;
    }

    private boolean isValid(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
