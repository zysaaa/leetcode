//package com.zysaaa.zysaaa20210225;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description: https://leetcode-cn.com/problems/pond-sizes-lcci/
// * @author:zysaaa
// * @date: 2021/3/15 22:12
// */
//public class PondSizes {
//    public  int[] pondSizes(int[][] land) {
//        List<Integer> resultList = new ArrayList<>();
//        for(int i = 0; i < land.length; i++){
//            for(int j = 0; j < land[0].length; j++){
//                if(land[i][j] == '0'){
//                    resultList.add(dfs(land, i, j));
//                }
//            }
//        }
//        // todo....
//
//    }
//
//    private int dfs(int[][] land, int i, int j) {
//
//        if (i < 0 || j < 0 || i >= land.length || j >= land.length || land[i][j] != 0) {
//            return 0;
//        }
//        land[i][j] = -1;
//        int count = 1;
//        //fixme....
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//        count += dfs(land, i+1, j+1);
//
//        return count;
//    }
//}
