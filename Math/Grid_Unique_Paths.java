/*
* A robot is located at the top-left corner of an A x B grid.
* The robot can only move either down or right at any point in time.
* The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
* How many possible unique paths are there?
* Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
* Example :
    Input : A = 2, B = 2
    Output : 2
    2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
                  OR  : (0, 0) -> (1, 0) -> (1, 1)
 * */

public class Solution {
    public int uniquePaths(int A, int B) {
        return getUniquePaths(0, 0, A, B);
    }

    public int getUniquePaths(int x, int y, int A, int B) {
        if (x == A || y == B) return 0;
        if (x == A-1 && y == B-1) return 1;
        return getUniquePaths(x+1, y, A, B) + getUniquePaths(x, y+1, A, B);
    }
}
