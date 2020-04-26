/*
* Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
* If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.
* Note:
    1. The replacement must be in-place, do **not** allocate extra memory.
    2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
* Input Format:
    The first and the only argument of input has an array of integers, A.
* Output Format:
    Return an array of integers, representing the next permutation of the given array.

* Solution Approach:
    * Find the highest index i such that s[i] < s[i+1]. If no such index exists, the permutation is the last permutation.
    * Find the highest index j > i such that s[j] > s[i]. Such a j must exist, since i+1 is such an index.
    * Swap s[i] with s[j].
    * Reverse the order of all of the elements after index i till the last element.
* */

public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        int k = -1;
        int l = 0;
        // Initial Check
        for (int i=0; i<n-1; i++) {
            if (A.get(i) < A.get(i+1)) {
                k = i;
            }
        }

        if (k == -1) {
            Collections.sort(A);
            return A;
        }

        // Finding next permutation
        for (int i=k+1; i<n;i++) {
            if (A.get(i) > A.get(k)) {
                l = i;
            }
        }

        // Swapping
        int temp = A.get(l);
        A.set(l, A.get(k));
        A.set(k, temp);

        // Reverse the right part
        int j = k + 1;
        int last = n-1;
        while(j <= last){
            temp = A.get(j);
            A.set(j, A.get(last));
            A.set(last, temp);
            j++;
            last--;
        }
        return A;
    }
}
