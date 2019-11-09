package tencent50;

import datastructure.TreeNode;

class lowestCommonAncestorBST {
    /*
        这题的做法和普通二叉树完全不同，只需要递归；
        如果某节点是p和q的LCS，那么p和q必然分别在它的左子树和右子树上；
        如果p和q的值都大于root的值，说明LCS在root的右子树里；反之在左子树里；
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}