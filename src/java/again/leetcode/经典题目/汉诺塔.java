package again.leetcode.经典题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 汉诺塔 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }
    public void hanota(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if(size == 1) {
            C.add(A.remove(A.size()-1));
        }else {
            hanota(size-1, A, C, B);
            C.add(A.remove(A.size()-1));
            hanota(size-1, B, A, C);
        }
    }
}
