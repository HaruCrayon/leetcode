package com.lee.algorithm.backtracking.leetcode;

import java.util.*;

/**
 * @description: 电话号码的字母组合
 * @date: 2025/3/22
 */
public class Leetcode17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return queue;
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> letters = map.get(digits.charAt(0));
        queue.addAll(letters);
        for (int i = 1; i < digits.length(); i++) {
            letters = map.get(digits.charAt(i));
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String poll = queue.poll();
                for (String letter : letters) {
                    queue.offer(poll + letter);
                }
            }
        }
        return queue;
    }
}
