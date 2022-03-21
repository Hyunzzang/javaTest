package com.zzang.test.top50.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
 * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i <= k is in wordList.
 * Note that beginWord does not need to be in wordList. sk == endWord Given two words, beginWord and
 * endWord, and a dictionary wordList, return the number of words in the shortest transformation
 * sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "lot", "log", "cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
        WordLadder a = new WordLadder();
        System.out.println(a.ladderLength_neighbor("hit", "cog", wordList));
    }

    public int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) {
                    return level;
                }
                for (String neighbor : neighbors(str, wordList)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return 0;
    }

    public List<String> neighbors(String s, List<String> wordList) {

        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;// ait~zit
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
