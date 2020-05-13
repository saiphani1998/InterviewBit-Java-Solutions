/*
* Given three sorted arrays A, B and Cof not necessarily same sizes.
* Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that
* a, b, c belongs arrays A, B, C respectively.
* i.e. minimize | max(a,b,c) - min(a,b,c) |.
* Example :
    Input:
        A : [ 1, 4, 5, 8, 10 ]
        B : [ 6, 9, 15 ]
        C : [ 2, 3, 6, 6 ]
    Output:
        1
    Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
* */

public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        int p = A.size();
        int q = B.size();
        int r = C.size();

        while (i<p && j<q && k<r) {
            int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

            if (maximum - minimum < diff) {
                diff = maximum - minimum;
            }

            if (diff == 0) {
                break;
            }

            if (A.get(i) == minimum) {
                i++;
            } else if (B.get(j) == minimum) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }
}
