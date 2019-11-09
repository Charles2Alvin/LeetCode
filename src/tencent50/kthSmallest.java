package tencent50;

import datastructure.TreeNode;

public class kthSmallest {
    int k, val;
    private void inorderTraversal(TreeNode root) {
        // 精髓在于找到值后提前终止遍历，
        if (root == null || k <= 0) return;
        inorderTraversal(root.left);
        if (--k == 0) {
            val = root.val;
        }
        inorderTraversal(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorderTraversal(root);
        return val;
    }
}
