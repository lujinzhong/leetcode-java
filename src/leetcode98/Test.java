package leetcode98;

import utils.TreeNode;

import java.util.ArrayList;

public class Test {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private ArrayList<Integer> result;

    public boolean isValidBST(TreeNode root) {
        // 解法1，中序遍历，再看获得的数组是不是升序的,遍历一下是不是递增的
        result = new ArrayList<>();
        MOrder(root);
        for (int i = 0 ; i < result.size(); i++) {
            //遍历到最后一个, i = result.size -1
            if (i == result.size() -1) return true;
            if (result.get(i) >= result.get(i+1) ) return false;
        }
        return true;
        // 解法2，递归判断，每颗树是不是都遵循 左孩子 < 根 < 右孩子
//        return isValid(root, null, null);
    }


    /**
     * 中序遍历
     * @param root
     */
    public void MOrder(TreeNode root) {
        if (root == null ) return;
        // 左 根 右
        MOrder(root.left);
        result.add(root.val);
        MOrder(root.right);
    }



    /**
     * 解法2 ，递归判断处理
     * @param root 根节点
     * @param min
     * @param max
     * @return
     */
    public boolean isValid(TreeNode root ,Integer min , Integer max)
    {
        // 每棵子树都需要满足 左孩子 < 根 < 右孩子
        // 我们可以发现左子树的

        if (root  == null ) return true;
        if (min != null && root.val <= min ) return false;
        if (max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
