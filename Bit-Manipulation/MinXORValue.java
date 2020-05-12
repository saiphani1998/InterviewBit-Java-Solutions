/*
* Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
* Input Format:
    First and only argument of input contains an integer array A
* Output Format:
    return a single integer denoting minimum xor value
* Constraints:
    2 <= N <= 100 000
    0 <= A[i] <= 1 000 000 000
* For Example :
    * Input 1:
        A = [0, 2, 5, 7]
    Output 1:
        2
    Explanation:
        0 xor 2 = 2
    * Input 2:
        A = [0, 4, 7, 9]
    Output 2:
        3
*
* */

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 0; i<A.size()-1; i++) {
            int xor = A.get(i)^A.get(i+1);
            if (xor < min) {
                min = xor;
            }
        }
        return min;
    }
}
