package again.leetcode.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class 最长连续序列 {

    public static void main(String[] args) {
        System.out.println(new 最长连续序列().longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {

        Set<Integer> num_set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int cur = num;
                int tmp = 1;
                while (num_set.contains(++cur)) {
                    tmp++;
                }
                result = Math.max(result, tmp);
            }
        }
        return result;
    }

}
