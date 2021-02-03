package com.zysaaa.zysaaa20210203;

/**
 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

 示例 1：

 输入: s = "leetcode"
 输出: false
 示例 2：

 输入: s = "abc"
 输出: true
 限制：

 0 <= len(s) <= 100
 如果你不使用额外的数据结构，会很加分。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/is-unique-lcci
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 注意是BST
 * @author:zysaaa
 * @date: 2021/2/3 19:32
 */
public class IsUnique {



    // 方法肯定有很多种

    // 最暴力的
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    return false;
                }
            }
        }
        return true;

    }

    // 使用str api  比上面的慢 理论上
    public boolean isUnique2(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (astr.lastIndexOf(chars[i]) != i) {
                return false;
            }
        }
        return true;

    }


    // 借助第三方  --如果是字母的话
    public boolean isUnique3(String astr) {
        int[] hash = new int[26];
        for(char ch : astr.toCharArray()) {
            hash[ch - 'a']++;
            if(hash[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }
}
