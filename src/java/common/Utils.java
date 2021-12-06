package common;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class Utils {

    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
