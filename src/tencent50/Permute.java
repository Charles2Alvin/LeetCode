package tencent50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        backTrack(output, numsList, 0, n);
        return output;
    }

    private void backTrack(List<List<Integer>> output, List<Integer> numsList, int first, int n) {
        if (first == n) {
            output.add(new ArrayList<>(numsList));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(numsList, first, i);
            backTrack(output, numsList, first + 1, n);
            Collections.swap(numsList, first, i);
        }
    }
}