package dp;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class Fibonacci {

    static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        while (n -- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    static int fibByDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }
}
