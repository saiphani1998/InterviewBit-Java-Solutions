/*
* Given an unsorted integer array, find the first missing positive integer.
* Example:
    Given [1,2,0] return 3,
    [3,4,-1,1] return 2,
    [-8, -7, -6] returns 1
* Your algorithm should run in O(n) time and use constant space.
* */

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int i = 0;
        int n = A.size();
        while (i < n) {
            if (A.get(i) <=0 || A.get(i) == i+1 || A.get(i) > n) {
                i++;
            }
            else if (!(A.get(A.get(i) - 1).equals(A.get(i)))) {
                int swapIndex = A.get(i)-1;
                int temp = A.get(i);
                A.set(i, A.get(swapIndex));
                A.set(swapIndex,temp);
            }
            else {
                i++;
            }
        }
        i = 0;
        while (i<n && A.get(i) == i+1) {
            i++;
        }
        return i+1;
    }
}
