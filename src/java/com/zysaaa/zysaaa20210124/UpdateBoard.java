package com.zysaaa.zysaaa20210124;

import java.util.Arrays;

/**
 * @description: 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 *
 * 我吐了，看懂题目花了一半
 *
 * @author:zysaaa
 * @date: 2021/1/24 15：08
 */
public class UpdateBoard {

    public static void main(String[] args) {
        char[][] chars = updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (char i[] : chars) {

            for (char j : i) {

                System.out.print(j + " ");

            }

            System.out.println();

        }

        System.out.println();

    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }


    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'B' || Character.isDigit(board[i][j]) || board[i][j] == 'X') {
            return;
        }

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }

        // 判断周边有没有地雷
        int numBoom = 0;
        numBoom += hasBoom(board, i - 1, j) ? 1 : 0;
        numBoom += hasBoom(board, i - 1, j - 1) ? 1 : 0;
        numBoom += hasBoom(board, i, j - 1) ? 1 : 0;
        numBoom += hasBoom(board, i + 1, j - 1) ? 1 : 0;
        numBoom += hasBoom(board, i + 1, j) ? 1 : 0;
        numBoom += hasBoom(board, i + 1, j + 1) ? 1 : 0;
        numBoom += hasBoom(board, i, j + 1) ? 1 : 0;
        numBoom += hasBoom(board, i - 1, j + 1) ? 1 : 0;
        if (numBoom != 0) {
            board[i][j] = String.valueOf(numBoom).charAt(0);
        } else {
            board[i][j] = 'B';
            dfs(board, i - 1, j);
            dfs(board, i - 1, j - 1);
            dfs(board, i, j - 1);
            dfs(board, i + 1, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i + 1, j + 1);
            dfs(board, i, j + 1);
            dfs(board, i - 1, j + 1);
        }


    }

    public static boolean hasBoom(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }

        if (board[i][j] == 'M' || board[i][j] == 'X') {
            return true;
        }
        return false;
    }

}
