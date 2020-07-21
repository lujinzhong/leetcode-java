package Leetcode236;

import utils.TreeNode;

public class Test {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //寻找普通树的公共祖先
        //1.暴力解法，根据两个节点的路径，来找出最早重叠的部分，但是要求孩子有指向父节点的指针存储
        // 2. 递归解法，题目要求两个节点一定存在，先判断根节点是不是两个节点其中之一，是的话，它就是公共节点
        // 不是的话，分布递归左右子树，直到有个等于 p | q 的节点出现，返回对应的 root
        if (root == null || root == q || root == p) return root;
        //如果根不是，那就递归遍历左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { // 左子树和右子树都没有要找的
            return root;
        }else if (left == null){ //左子树没有，说明在右边，返回右子树的最终结果
            return right;
        }else { // 右子树没有，说明在左边，返回左子树的最终结果
            return left;
        }
    }
}
