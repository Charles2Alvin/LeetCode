package tencent50;

import java.util.LinkedList;
import java.util.List;

public class grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int times = 1 << n;
            for (int j = res.size()- 1; j > - 1; j--) {
                res.add(times + res.get(j));
            }
        }
        return res;
    }
}
