/*
* Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.
* Your algorithm’s runtime complexity must be in the order of O(log n).
* Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A,
* if B is not found in A return [-1, -1].
*For Example
    * Input 1:
        A = [5, 7, 7, 8, 8, 10]
        B = 8
    Output 1:
        [3, 4]
    Explanation 1:
        First occurence of 8 in A is at index 3
        Second occurence of 8 in A is at index 4
        ans = [3, 4]
    * Input 2:
        A = [5, 17, 100, 111]
        B = 3
    Output 2:
        [-1, -1]
*
* Approach: 1st do binary search and find out if the given number exist or not.
* If exist, Then do binary serach on left and right sides from that position.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int low = 0, high = A.size()-1, mid = (low+high)/2;
        int start = -1, end = -1;
        while(low<=high) {
            if(A.get(mid) == B) {
                int leftSearch = search(A,B,low,mid-1,true);
                int rightSearch = search(A,B,mid+1,high,false);
                start = leftSearch == -1 ? mid : leftSearch;
                end = rightSearch == -1 ? mid : rightSearch;
                break;
            } else if(B < A.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low+high)/2;
        }
        ArrayList<Integer> resList = new ArrayList<>();
        resList.add(start);
        resList.add(end);
        return resList;
    }
    public int search(List<Integer> A, int B, int low, int high, boolean left) {
        int position = -1, mid = (low+high)/2;
        while (low<=high) {
            if(A.get(mid) == B) {
                position = mid;
                if (left) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else if(B < A.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low+high)/2;
        }
        return position;
    }
}
