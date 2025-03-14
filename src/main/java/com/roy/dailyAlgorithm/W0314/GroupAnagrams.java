package com.roy.dailyAlgorithm.W0314;

import java.util.*;

/**
 * 题目：字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。当且仅当两个字符串包含的字母和个数相同
 */
public class GroupAnagrams {

    /**
     * 题解思路：每一组字母异位词的字母和个数是一样的，需要找到他们的共同点：将字符排序之后组成的字符串都是一样的，然后再判断字符串一样的就能知道是否为同一组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsOfficial(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newKey = new String(charArray);
            List<String> list = map.getOrDefault(newKey, new ArrayList<>());
            list.add(str);
            map.put(newKey, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
