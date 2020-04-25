/*
* Reverse digits of an integer.
* Example1:
    x = 123,
    return 321
* Example2:
    x = -123,
    return -321
* Return 0 if the result overflows and does not fit in a 32 bit signed integer
*/

public class Solution {
    public int reverse(int A) {
        long res=0;
        boolean isNegative = A<0;
        A = A<0 ? -1*A: A;
        while(A > 0) {
            A = (A*10) + A%10;
            A/=10;
        }
        return isNegative ? (int)(-1*res) : (int)res;
    }
}
