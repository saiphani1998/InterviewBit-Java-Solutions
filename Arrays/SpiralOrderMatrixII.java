/*
* Given an integer A, generate a square matrix filled with elements from 1 to A^2 in spiral order.
* Input Format: The first and the only argument contains an integer, A.
* Output Format: Return a 2-d matrix of size A x A satisfying the spiral order.
* Constraints: 1 <= A <= 1000
* Examples:
    * Input 1:
        A = 3
    * Output 1:
        [   [ 1, 2, 3 ],
            [ 8, 9, 4 ],
            [ 7, 6, 5 ]   ]

    * Input 2:
        4
    * Output 2:
        [   [1, 2, 3, 4],
            [12, 13, 14, 5],
            [11, 16, 15, 6],
            [10, 9, 8, 7]   ]
* */

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(A);
        for (int i=0; i<A; i++) {
            result.add(new ArrayList<>(A));
            for (int j=0; j<A; j++) {
                result.get(i).add(0);
            }
        }

        int left = 0, right = A-1, up = 0 , down = A-1;
        int num = 1;
        while (left <= right && up <= down) {
            for (int i=left; i<= right; i++) {
                result.get(up).set(i, num);
                num++;
            }
            up++;
            for (int j=up; j<= down; j++) {
                result.get(j).set(right, num);
                num++;
            }
            right--;
            for (int i=right; i>= left; i--) {
                result.get(down).set(i, num);
                num++;
            }
            down--;
            for (int j=down; j>= up; j--) {
                result.get(j).set(left, num);
                num++;
            }
            left++;
        }

        return result;
    }
}
