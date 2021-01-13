package com.zysaaa.zysaaa20210113;

/**
 * @description: 递归的理解
 * 目前我找到的对递归最恰当的比喻，就是查词典。我们使用的词典，本身就是递归，为了解释一个词，需要使用更多的词。当你查一个词，发现这个词的解释中某个词仍然不懂，于是你开始查这第二个词，可惜，第二个词里仍然有不懂的词，于是查第三个词，这样查下去，直到有一个词的解释是你完全能看懂的，那么递归走到了尽头，然后你开始后退，逐个明白之前查过的每一个词，最终，你明白了最开始那个词的意思。。。
 *
 * 作者：李鹏
 * 链接：https://www.zhihu.com/question/20507130/answer/52759136
 * 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/13 22:01
 */
public class FindMax {

    public static void main(String[] args) {
        System.out.println(max(new int[]{1,2,432,543,52,4123,434,543,63,4523,42}));
    }

    public static int max(int[] arr) {
        return findMax(arr, 0, arr.length - 1);
    }

    public static int findMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int a = arr[L];
        int b = findMax(arr, L+1, R);
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
