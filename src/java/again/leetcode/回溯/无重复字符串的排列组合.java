package again.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/permutation-i-lcci/
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * @author: zysaaa
 * @date: 2021/10/25 10:30
 */
public class 无重复字符串的排列组合 {

    public String[] permutation(String S) {


        List<String> list = new ArrayList<>();
        solve(S.toCharArray(), list, 0);
        return list.toArray(new String[] {});

    }


    public void solve(char[] chars, List<String> list, int index) {





    }
}
