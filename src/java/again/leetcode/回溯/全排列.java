package again.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zysaaa
 * @date: 2021/11/4 22:15
 */
public class 全排列 {

    public static void main(String[] args) {
        System.out.println(new 全排列().permute(new int[] {1,2,3}));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }

        }

    }
}
