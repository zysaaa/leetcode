//package com.zysaaa.zysaaa20210225;
//
//import java.util.Stack;
//import java.util.stream.IntStream;
//
///**
// * @description: https://leetcode-cn.com/problems/backspace-string-compare/
// * @author:zysaaa
// * @date: 2021/3/10 21:38
// */
//public class Turn {
//    public boolean backspaceCompare(String S, String T) {
//
//    }
//
//    public String act(String str) {
//
//        if (str == null || str.equals("")) {
//            return str;
//        }
//
//        Stack<Character> stack = new Stack<>();
//
//        char[] chars = str.toCharArray();
//        int length = chars.length;
//
//        for (int i = 0; i < length; i++) {
//            if (chars[i] == '#') {
//                if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//            } else {
//                stack.push(chars[i]);
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder("");
//        while (!stack.isEmpty()) {
//            stringBuilder.append(stack.pop());
//        }
//        return stringBuilder.reverse().toString();
//
//
//    }
//}
