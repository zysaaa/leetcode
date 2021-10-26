package again.common;

/**
 * @description: util
 * @author: zysaaa
 * @date: 2021/10/21 14:50
 */
public class Utils {
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
