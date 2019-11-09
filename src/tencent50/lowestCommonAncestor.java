package tencent50;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 其中一个能深搜到另一个（直接祖先）
        if (DFS(p, q)) return p;
        if (DFS(q, p)) return q;
        TreeNode ret = root;
        int depth = 0, maxDepth = -1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) queue.offer(head.left);
            if (head.right != null) queue.offer(head.right);
            if (DFS(head, p) && DFS(head, q) && depth > maxDepth) {
                maxDepth = depth;
                ret = head;
            }
            depth += 1;
        }
        return ret;
    }
    public boolean DFS(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return DFS(root.left, target) || DFS(root.right, target);
    }
}

/**
 * Definition for a binary tree node.
 * public class datastructure.TreeNode {
 *     int val;
 *     datastructure.TreeNode left;
 *     datastructure.TreeNode right;
 *     datastructure.TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.add(root);
        // 层序遍历并记录每个节点的parent
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        // 把p的祖先加到一个集合里
        HashSet<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p); // 自己也算是自己的祖先
            p = parent.get(p);
        }
        // 遍历q的祖先，如果它也是p的祖先，则为最近公共祖先
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}