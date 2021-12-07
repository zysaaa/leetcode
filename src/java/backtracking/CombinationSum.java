package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> list, int target, int[] candidates, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(result, list, target - candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }

    }
}
