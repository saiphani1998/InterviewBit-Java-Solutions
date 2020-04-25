/*
* Determine whether an integer is a palindrome. Do this without extra space.
* A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
* Negative numbers are not palindromic.
* Example :
    Input : 12121
    Output : True

    Input : 123
    Output : False
* */

public class Solution {
    public int isPalindrome(int A) {
        if(A<0) {
            return 0;
        }
        int N = A;
        int reverse = 0;
        while (N > 0) {
            reverse *= 10;

            reverse += N % 10;
            N = N / 10;
        }
        return reverse == A ? 1 : 0;
    }
}
