package com.roy.dailyAlgorithm.W0314;

import java.util.*;

/**
 * 题目：最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 感悟：Hash适合用于快速判断某一个数是否存在
 */
public class LongestConsecutive {

    /**
     * 题解：每个数都判断一次这个数是不是连续序列的开头那个数。
     *
     * 怎么判断呢，就是用哈希表查找这个数前面一个数是否存在，即num-1在序列中是否存在。存在那这个数肯定不是开头，直接跳过。
     * 因此只需要对每个开头的数进行循环，直到这个序列不再连续，因此复杂度是O(n)。
     * 以题解中的序列举例: [100，4，200，1，3，4，2]
     * 去重后的哈希序列为： [100，4，200，1，3，2]
     * 按照上面逻辑进行判断：
     * 元素100是开头,因为没有99，且以100开头的序列长度为1
     * 元素4不是开头，因为有3存在，过，
     * 元素200是开头，因为没有199，且以200开头的序列长度为1
     * 元素1是开头，因为没有0，且以1开头的序列长度为4，因为依次累加，2，3，4都存在。
     * 元素3不是开头，因为2存在，过，
     * 元素2不是开头，因为1存在，过。
     * 完
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result= 0;
        for (int num : set) {
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum + 1)){
                    currentStreak += 1;
                    currentNum += 1;
                }
                result = Math.max(currentStreak, result);
            }
        }

        return result;
    }
}
