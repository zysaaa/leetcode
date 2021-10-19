package com.zysaaa.zysaaa20210124;

/**
 * @description: 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 *
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-matches-in-tournament
 * @author:zysaaa
 * @date: 2021/1/24 20:21
 */
public class NumberOfMatches {

    public static void main(String[] args) {
        //System.out.println(numberOfMatches(14));
    }

    public  int numberOfMatches(int n) {
        if (n == 1 || n == 0) {
            return 0;
        }
        dfs(n);
        return result;
    }

     int result;
    public  void dfs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            result++;
            return;
        }
        result += n / 2;
        dfs(n % 2 == 0 ? n / 2 : n / 2 + 1);
    }
}
