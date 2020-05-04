/*
* Given a matrix of integers A of size N x M and an integer B.
* Write an efficient algorithm that searches for integar B in matrix A.
* This matrix A has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than or equal to the last integer of the previous row.
* Return 1 if B is present in A, else return 0.
* Note: Rows are numbered from top to bottom and columns are numbered from left to right.
*
* For Example
    Input 1:
        A =
        [ [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]  ]
        B = 3
    Output 1:
        1

    Input 2:
        A = [   [5, 17, 100, 111]
                [119, 120,  127,   131]    ]
        B = 3
    Output 2:
        0
*
* Approach: loop through rows and check if the search element lies in the range of that row.
    if yes, then do binary search for that element on that row. if found, return 1 else 0.
    if it does not fit in any row, return 0;
* */

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int row = A.size(), column = A.get(0).size();
        for(int i = 0; i<row; i++) {
            if (B == A.get(i).get(0)) {
                return 1;
            } else if (B == A.get(i).get(column-1)) {
                return 1;
            } else if (B > A.get(i).get(0) && B < A.get(i).get(column-1)) {
                return binarySearch(A.get(i),B);
            }
        }
        return 0;
    }

    public int binarySearch(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size(), mid = 0;
        while (low<=high) {
            mid = low + (high-low)/2;
            if (A.get(mid) == B) {
                return 1;
            } else if (B < A.get(mid)) {
                high = mid - 1;
            } else if (B > A.get(mid)) {
                low = mid+1;
            }
        }
        return 0;
    }
}
