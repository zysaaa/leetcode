package again.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author: zysaaa
 * @date: 2021/10/26 16:21
 */
public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {
        System.out.println(new 找到所有数组中消失的数字().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] x = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            x[nums[i]]++;
        }
        for (int i = 1; i < x.length; i++) {
            if(x[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
}
