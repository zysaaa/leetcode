package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @author: zysaaa
 * @date: 2021/11/3 19:19
 */
public class 树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

}
