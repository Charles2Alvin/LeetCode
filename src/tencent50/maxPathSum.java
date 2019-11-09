package tencent50;

import datastructure.TreeNode;

public class maxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(0, maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));
        int newSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newSum);
        return root.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
