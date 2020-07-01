/*
* Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
* Try to solve it in linear time/space.
* Example :
    Input : [1, 10, 5]
    Output : 5
    Return 0 if the array contains less than 2 elements.
* You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
* You may also assume that the difference will not overflow.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if (A.size() < 2) {
            return 0;
        }
        int i = 0, arr[] = new int[A.size()];
        for (int a : A) {
            arr[i++] = a;
        }
        Arrays.sort(arr);
        int diff = Integer.MIN_VALUE;
        for (i = 1; i<arr.length; i++) {
            int currentDifference = arr[i] - arr[i-1];
            if (currentDifference > diff) {
                diff = currentDifference;
            }
        }
        return diff;
    }
}
