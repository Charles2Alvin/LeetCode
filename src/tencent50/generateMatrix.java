package tencent50;

public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int count = 0;
        int[][] ret = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                ret[up][i] = ++count;
            }
            for (int i = up + 1; i < down; i++) {
                ret[i][right] = ++count;
            }
            if (left < right && up < down) {
                for (int i = right; i > left; i--) {
                    ret[down][i] = ++count;
                }
                for (int i = down; i > up; i--) {
                    ret[i][left] = ++ count;
                }
            }
            left++;
            up++;
            right--;
            down--;
        }
        return ret;
    }
}