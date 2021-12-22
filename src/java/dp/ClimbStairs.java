package dp;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        while (n -- > 2) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
