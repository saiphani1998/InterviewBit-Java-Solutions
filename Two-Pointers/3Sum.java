/*
* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
* Return the sum of the three integers.
    * Assume that there will only be one solution
* Example:
    given array S = {-1 2 1 -4},
    and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
*
* Approach: Sort the array and use 3 pointers to find the sum and absolute difference between sum and given number.
* */

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int b) {
        Collections.sort(A);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i< A.size()-2; i++) {
            int j = i+1;
            int k = A.size()-1;
            while (j<k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                int diff = Math.abs(sum - b);
                if (diff == 0) {
                    return b;
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if(sum <= b) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
