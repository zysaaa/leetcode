package again.leetcode.经典题目;

/**
 * @description: https://leetcode-cn.com/problems/majority-element/
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author: zysaaa
 * @date: 2021/10/26 17:02
 */
public class 多数元素 {

    public int majorityElement(int[] nums) {
        int result = 0;
        int num = 0;
        for (int i : nums) {
            if (num == 0) {
                result = i;
            }
            num += result == i ? 1 : -1;
        }
        return result;
    }
}
