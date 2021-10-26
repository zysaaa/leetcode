package again.leetcode.回溯;

import java.util.ArrayList;

/**
 *  @description: https://leetcode-cn.com/problems/permutation-i-lcci/
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * @author: zysaaa
 * @date: 2021/10/25 10:30
 */
public class 无重复字符串的排列组合 {

    int len;
    ArrayList<String> res;

    public static void main(String[] args) {
        System.out.println(new 无重复字符串的排列组合().permutation("qwe"));

    }
    public String[] permutation(String S) {
        char[] tmp = S.toCharArray();
        this.len = tmp.length;
        res = new ArrayList<String>();
        dfs(0, tmp);

        String[] res2 = (String[]) res.toArray(new String[0]);
        return res2;
    }

    private void dfs(int k, char[] tmp){
        if (k==len){
            res.add(new String(tmp));
            return;
        }
        for(int i=k;i<len;i++){
            swap(tmp, i, k);
            dfs(k+1, tmp);
            swap(tmp, i, k);
        }
    }

    private void swap(char[] s, int a, int b){
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}
