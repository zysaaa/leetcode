package again.leetcode.递归;

public class 字符串解码 {

    public static void main(String[] args) {
        System.out.println(new 字符串解码().decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        if (!s.contains("[")) {
            return s;
        }
        StringBuilder string = new StringBuilder();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                // 找到第一个'['
                for (int o = i+1; o < chars.length; o++) {
                    if (chars[o] == '[') {
                        int copyTimes = Integer.parseInt(s.substring(i, o));
                        // 找到对称的']'
                        int times = 0;
                        for (int j = o + 1; j<chars.length; j++) {
                            if (chars[j] == '[') {
                                times++;
                            }
                            if (chars[j] == ']') {
                                if (times == 0) {
                                    while (copyTimes -- > 0) {
                                        string.append(decodeString(s.substring(o + 1, j)));
                                    }
                                    i = j;
                                } else {
                                    times--;
                                }
                            }
                        }
                        break;
                    }
                }


            } else {
                string.append(chars[i]);
            }
        }
        return string.toString();
    }
}
