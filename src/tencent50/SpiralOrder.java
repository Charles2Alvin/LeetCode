package tencent50;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        // Define four boundaries
        int up = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (up <= bottom && left <= right) {
            for (int i = left; i <= right; i++) ans.add(matrix[up][i]);
            for (int i = up + 1; i <= bottom; i++) ans.add(matrix[i][right]);
            if (up < bottom && left < right) {
                for (int i = right - 1; i > left; i--) ans.add(matrix[bottom][i]);
                for (int i = bottom; i > up; i--) ans.add(matrix[i][left]);
            }
            up ++;
            bottom --;
            left ++;
            right --;
        }
        return ans;
    }
}