package tencent50;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
            k *= nums[i];
        }
        k = 1;
        for (int i = res.length - 1; i > -1; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
