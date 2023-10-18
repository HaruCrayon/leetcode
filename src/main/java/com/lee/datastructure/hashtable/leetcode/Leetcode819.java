package com.lee.datastructure.hashtable.leetcode;

import java.util.*;

/**
 * 819. 最常见的单词
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode819 {
    /*
        给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
        题目保证至少有一个词不在禁用列表中，而且答案唯一。
        禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     */

    /*
        思路:
        1. 将 paragraph 截取为一个个单词
        2. 将单词加入 map 集合，单词本身作为 key，出现次数作为 value，避免禁用词加入
        3. 在 map 集合中找到 value 最大的，返回它对应的 key 即可
     */
    public String mostCommonWord01(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        Optional<Map.Entry<String, Integer>> optional = map.entrySet().stream().max(Map.Entry.comparingByValue());

        return optional.map(Map.Entry::getKey).orElse(null);
    }

    // 优化1
    public String mostCommonWord02(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    // 优化2
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");
        HashMap<String, Integer> map = new HashMap<>();
        // 自己截取单词
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                String key = sb.toString();
                if (!set.contains(key)) {
                    map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                }
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            String key = sb.toString();
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        System.out.println(map);

        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Leetcode819 leetcode819 = new Leetcode819();
//        String key = leetcode819.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
//        String key = leetcode819.mostCommonWord("Bob", new String[]{"hit"});
        String key = leetcode819.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"});
        System.out.println(key); // ball
    }
}
