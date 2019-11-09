package tencent50;

import java.util.LinkedList;
import java.util.List;


public class subsets {
    // 回溯法！全排列、幂集之类的题目都是这个思路！
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(0, nums, res, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp) {
        res.add(new LinkedList(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
