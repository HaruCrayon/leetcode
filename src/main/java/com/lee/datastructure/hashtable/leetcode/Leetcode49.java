package com.lee.datastructure.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode49 {

    static class ArrayKey {
        int[] key = new int[26];

        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i); // 'a'97-97=0  'b'98-97=1
                key[ch - 97]++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }
    }

    /*
        解法1 思路
        题目中有说明：strs[i] 仅包含小写字母
        key = [2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]  26
        key = [2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]  26
        "beaat", "teaa"
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey key = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /*
        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // eat tea ate => aet
        // tan nat     => ant
        // bat         => abt
        // [(aet,{eat,tea,ate}), (ant,{tan,nat}), (abt,{bat})]

        解法2 思路
        1. 遍历字符串数组，每个字符串中的字符重新排序后作为 key
        2. 所谓分组，其实就是准备一个集合，把这些单词加入到 key 相同的集合中
        3. 返回分组结果
     */
    public List<List<String>> groupAnagrams01(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Leetcode49().groupAnagrams(strs);
        System.out.println(lists);
//        System.out.println(Arrays.toString(new int[26]));
    }
}
