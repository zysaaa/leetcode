package again.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/letter-case-permutation/
 * @author: zysaaa
 * @date: 2021/11/4 22:34
 */
public class 字母大小写全排列 {

    public static void main(String[] args) {
        System.out.println(new 字母大小写全排列().letterCasePermutation("a1b"));
    }

    public List<String> letterCasePermutation(String S) {

        List<String> list = new ArrayList<>();
        list.add(S);
        dfs(list, 0, S.toCharArray());
        return list;
    }


    public void dfs(List<String> list, int index, char[] chars) {

        if (index == chars.length) {
            return;
        }

        if (Character.isLetter(chars[index])) {
            dfs(list, index + 1, chars);
            chars[index] = Character.isLowerCase(chars[index]) ? Character.toUpperCase(chars[index])
                : Character.toLowerCase(chars[index]);
            list.add(new String(chars));
        }
        dfs(list, index + 1, chars);


    }
}
