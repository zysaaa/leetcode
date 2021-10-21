package again.leetcode.经典题目;

/**
 * @description: 斐波那契数列
 * @author: zysaaa
 * @date: 2021/10/21 13:40
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }


    // 迭代
    public static int fibonacci(int n) {

        if (n < 2) {
            return n;
        }
        int result = 0;
        int a = 0;
        int b = 1;
        while (n -- > 1) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;

    }

}
