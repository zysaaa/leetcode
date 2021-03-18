package com.zysaaa.zysaaa20210225;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/fizz-buzz/
 * @author:zysaaa
 * @date: 2021/3/18 21:43
 */
public class FizzBuzz {
    private static final String fizz = "Fizz";
    private static final String buzz = "Buzz";
    private static final String fb = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result.add(fb);
            } else if ( i % 3 == 0) {
                result.add(fizz);
            } else if (i % 5 == 0) {
                result.add(buzz);
            } else {
                result.add(String.valueOf(i));
            }

        }
        return result;
    }
}
