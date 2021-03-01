package com.zysaaa.zysaaa20210225;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/subsets/
 * @author:zysaaa
 * @date: 2021/3/1 13:03
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{0}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 1) {
            return null;
        }
        back(nums, 0, new ArrayList<>());
        result.add(new ArrayList<>());
        return result;

    }

    private void back(int[] nums, int begin, List<Integer> list) {
        if (begin == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            back(nums, i+1, list);
            list.remove(list.size() - 1);
        }
    }
}
