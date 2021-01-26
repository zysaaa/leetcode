package com.zysaaa.zysaaa20210126;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 *  和 CombinationSum Combine 结合起来看。
 *
 *
 *  class Solution {
 *     List<List<String>> resultList=new ArrayList<List<String>>();
 *     List<String> tmp=new ArrayList<String>();
 *     public List<List<String>> partition(String s){
 *         if(s!=null)
 *             backTrace(s,0);
 *         //System.out.println(resultList);
 *         return resultList;
 *     }
 *     void backTrace(String s,int begin){
 *         if(begin==s.length()){
 *             resultList.add(new ArrayList<String>(tmp));
 *             return;
 *         }
 *         for(int i=begin;i<s.length();i++){
 *             if(isPalindromes(s, begin,i)){
 *                 tmp.add(s.substring(begin,i+1));
 *                 backTrace(s,i+1);
 *                 tmp.remove(tmp.size()-1);
 *             }
 *         }
 *     }
 *     boolean isPalindromes(String s,int begin,int end){
 *         while(begin<end){
 *             if(s.charAt(begin)!=s.charAt(end)){
 *                 return false;
 *             }
 *             begin++;
 *             end--;
 *         }
 *         return true;
 *     }
 * }
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author:zysaaa
 * @date: 2021/1/26 21:53
 */
public class Partition {

    private static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        if (s == null) {
            return result;
        }
        dfs(s, new ArrayList<>(), 0);
        return result;
    }

    public static void dfs(String s, List<String> list, int begin) {

        if (begin == s.length()) {
            //list.add(s.substring(begin));
            result.add(new ArrayList<>(list));
            return;
        }
        int len = s.length();
        String temp = "";
        for (int i = begin; i < len; i++) {
            temp += s.substring(i, i+1);
            if (!isHuiWen(temp)) {
                continue;
            }
            list.add(temp);
            dfs(s, list, i+1);
            list.remove(list.size() - 1);
        }


    }

    private static boolean isHuiWen(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
