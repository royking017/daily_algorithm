package com.roy.dailyAlgorithm.W0313;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目【两数之和】
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class TwoNumbers {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target){
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > target){
                    continue;
                }
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    /**
     *  理解：使用空间换时间，本质逻辑是已知i、target，寻找target-i这个数存在的位置
     *  将x存到map中后即可将双层循环替换为单层循环
     */
    public int[] twoSumOfficial(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
