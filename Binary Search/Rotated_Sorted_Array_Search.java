/*
*
* Given an array of integers A of size N and an integer B.
* array A is rotated at some pivot unknown to you beforehand.
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
* You are given a target value B to search. If found in the array, return its index, otherwise return -1.
* You may assume no duplicate exists in the array.
* NOTE:- Array A was sorted in non-decreasing order before rotation.
*
* For Example:
    Input 1:
        A = [4, 5, 6, 7, 0, 1, 2, 3]
        B = 4
    Output 1:
        0
    Explanation 1:
     Target 4 is found at index 0 in A.
    Input 2:
        A = [5, 17, 100, 3]
        B = 6
    Output 2:
        -1
*
* Approach: Findout the pivot point of rotation,
* if the number is greater than 1st element, do binary search on left part of the pivot else on the right part of the pivot.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int n = A.size(), pivot = findPivot(A,0,n-1);
        if (pivot == -1)
            return binarySearch(A, B, 0, n-1);
        if (A.get(pivot) == B)
            return pivot;
        if (A.get(0) <= B)
            return binarySearch(A, B, 0, pivot-1);
        return binarySearch(A, B, pivot+1, n-1);
    }

    public int binarySearch(List<Integer>A, int B, int low, int high) {
        int mid = 0;
        while (low<=high) {
            mid = low + (high - low)/2;
            if (A.get(mid) == B) {
                return mid;
            } else if (B < A.get(mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int findPivot (List<Integer> A , int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;
        int mid = low + (high - low)/2;
        if (mid < high && A.get(mid) > A.get(mid + 1))
            return mid;
        if (mid > low && A.get(mid) < A.get(mid - 1))
            return (mid-1);
        if (A.get(low) >= A.get(mid))
            return findPivot(A, low, mid-1);
        return findPivot(A, mid + 1, high);
    }
}
