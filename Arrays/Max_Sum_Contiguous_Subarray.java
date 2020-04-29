/*
* Find the contiguous subarray within an array, A of length N which has the largest sum.
* Input Format:
    The first and the only argument contains an integer array, A.
* Output Format:
    Return an integer representing the maximum possible sum of the contiguous subarray.
* Constraints:
    1 <= N <= 1e6
    -1000 <= A[i] <= 1000
* For example:
    Input 1:
        A = [1, 2, 3, 4, -10]
    Output 1:
        10
    Explanation 1:
        The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

    Input 2:
        A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Output 2:
        6
    Explanation 2:
        The subarray [4,-1,2,1] has the maximum possible sum of 6.
* Approach:
    if we compare max_so_far with max_ending_here only if max_ending_here is greater than 0.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int maxSoFar = A.get(0);
        int maxEndingHere = A.get(0);
        for(int i = 1; i<A.size(); i++) {
            maxEndingHere = Math.max(A.get(i), maxEndingHere+A.get(i)); // To handle the case when the sum is already negative.
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
