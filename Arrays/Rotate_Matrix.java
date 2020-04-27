/*
* You are given an n x n 2D matrix representing an image.
* Rotate the image by 90 degrees (clockwise).
* You need to do this in place.
* Note that if you end up using an additional array, you will only receive partial score.
* Example:
    If the array is
    [
        [1, 2],
        [3, 4]
    ]
    Then the rotated array becomes:
    [
        [3, 1],
        [4, 2]
    ]
*
* Approach: Transpose the matrix and then reverse every row.
* */

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        for (int i = 0; i < a.size(); i++){
            Collections.reverse(a.get(i));
        }
    }

    void transpose(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.get(0).size(); j++) {
                int temp = arr.get(j).get(i);
                arr.get(j).set(i,arr.get(i).get(j));
                arr.get(i).set(j,temp);
            }
        }
    }
}
