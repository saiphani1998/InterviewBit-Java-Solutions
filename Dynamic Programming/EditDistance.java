/*
* Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
* You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character
* Input Format:
    The first argument of input contains a string, A.
    The second argument of input contains a string, B.
* Output Format: Return an integer, representing the minimum number of steps required.
* Constraints: 1 <= length(A), length(B) <= 450
* Examples:
    * Input 1:
        A = "abad"
        B = "abac"
    * Output 1: 1
    * Explanation 1:
        Operation 1: Replace d with c.

    * Input 2:
        A = "Anshuman"
        B = "Antihuman"
    * Output 2: 2
    * Explanation 2:
        => Operation 1: Replace s with t.
        => Operation 2: Insert i.
* */

public class Solution {
    public int minDistance(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();
        int mat[][] = new int[l1+1][l2+1];
        mat[0][0] = 0;
        for (int i=1;i<l1+1;i++) {
            mat[i][0] = i;
        }
        for (int i=1;i<l2+1;i++) {
            mat[0][i] = i;
        }

        for (int i=1;i<l1+1;i++) {
            for (int j=1;j<l2+1;j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    mat[i][j] = mat[i-1][j-1];
                } else {
                    mat[i][j] = Math.min(Math.min(mat[i-1][j-1],
                            mat[i-1][j]), mat[i][j-1])+1;
                }
            }
        }
        return mat[l1][l2];
    }
}
