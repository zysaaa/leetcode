package com.zysaaa.zysaaa20210225;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/power-set-lcci/
 * @author:zysaaa
 * @date: 2021/3/3 21:00
 */
public class Subsets2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        back(nums, 0, new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }


    private void back(int[] nums, int begin, List<Integer> list) {

        if (begin == nums.length - 1) {
            list.add(nums[begin]);
            result.add(new ArrayList<>(list));

            list.remove(list.size() - 1);
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
