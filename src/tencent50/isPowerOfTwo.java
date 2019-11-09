package tencent50;

class isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
         /*
         只要是2的幂，必然最高位是1，其他位是0；减一之后最高位为0，其他为1
         两数按位做与运算，结果必然为0
         */
        return n > 0 && (n & (n - 1)) == 0;
    }
}