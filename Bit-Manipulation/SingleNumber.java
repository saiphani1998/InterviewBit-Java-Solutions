/*
* Given an array of integers, every element appears twice except for one. Find that single one.
* Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* Input Format:
    First and only argument of input contains an integer array A
* Output Format:
    return a single integer denoting single element
* Constraints:
    2 <= N <= 2 000 000  
    0 <= A[i] <= INT_MAX
* For Example :
    * Input 1:
        A = [1, 2, 2, 3, 1]
    Output 1:
        3
    Explanation:
        3 occurs only once

    * Input 2:
        A = [1, 2, 2]
    Output 2:
        1
*
* Approach: aXORa = 0 and 0(XOR)a = a so, xoring all the elements of array results the non-repeating element; 
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int xor = A.get(0);
        for (int i = 1; i<A.size(); i++) {
            xor^=A.get(i);
        }
        return xor;
    }
}
