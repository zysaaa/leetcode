package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/word-search/
 * @author:zysaaa
 * @date: 2021/3/27 14:29
 */
public class Exist {

    public static void main(String[] args) {
        char[][] input = new char[][]{{'A','B'}};
        System.out.println(new Exist().exist(input, "AB"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, String word, int index, int i, int j) {

        if (index >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0') {
            return false;
        }
        if (index == word.length() - 1) {
            if (board[i][j] == word.charAt(index)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (board[i][j] == word.charAt(index)) {
                board[i][j] += 256;
                boolean result =  dfs(board, word, index + 1, i, j-1) || dfs(board, word, index + 1, i-1, j)
                    || dfs(board, word, index + 1, i, j + 1) || dfs(board, word, index + 1, i+1, j);
                board[i][j] -= 256;
                return result;
            } else {
                return false;
            }
        }

    }
}
