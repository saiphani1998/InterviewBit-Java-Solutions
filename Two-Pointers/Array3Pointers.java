/*
* You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
* Find i, j, k such that :
    max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
    Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
* abs(x) is absolute value of x and is implemented in the following manner :
      if (x < 0) return -x;
      else return x;

* Example :
    Input :
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]
    Output : 5
         With 10 from A, 15 from B and 10 from C.
*
* Approach: To maximize the difference, we need to find the difference between largest and the smallest values of A[i],B[j],C[k].
    * Now to minimize the maximum difference, we need to take the next element of the minimum element of A[i],B[j],C[k].
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0;
        int j = 0;
        int k = 0;

        int ans = Integer.MAX_VALUE;
        while (i<A.size() && j<B.size() && k<C.size()) {
            int minVal = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maxVal = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            if (ans > maxVal - minVal) {
                ans = maxVal - minVal;
            }

            if (minVal == A.get(i)) i++;
            else if (minVal == B.get(j)) j++;
            else k++;
        }
        return ans;
    }
}
