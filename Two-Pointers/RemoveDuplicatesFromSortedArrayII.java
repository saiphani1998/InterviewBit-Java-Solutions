/*
* Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
* Do not allocate extra space for another array, you must do this in place with constant memory.
* Note that even though we want you to return the new length, make sure to change the original array as well in place
* For example,
    * Given input array A = [1,1,1,2],
    * Your function should return length = 3, and A is now [1,1,2].
*
* Approach:
    * Since the array is sorted, Keeping track of count of occurances each element at that point of time is enough.
    * We should maintain a temporary list to copy the elements that are needed.
    * If the count is less than 2, we will add the item to temporary list.
    * After iterating through the given arraylist, we clear the actual list and add the required values to it.
    * Then we clear the temporary list as well.
    * KEY POINTS to remember here are:
        * Since here comparison is between Integer objects and not int objects, we need to use of equals() method and not '==' operator
        * Do not try to remove arraylist element inplace using "remove()" method because
        * it's complexity is O(n) due to which the entire solution time complexity goes to O(n^2).
*
* */

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (a.size() <=1) {
            return a.size();
        }
        int count = 1;
        temp.add(a.get(0));
        for (int j = 1; j<a.size(); j++) {
            if (a.get(j).equals(a.get(j-1))) {
                if (count < 2) {
                    temp.add(a.get(j));
                }
                count++;
            } else {
                count = 1;
                temp.add(a.get(j));
            }
        }
        a.clear();
        for (int num:temp) {
            a.add(num);
        }
        temp.clear();
        System.gc();
        return a.size();
    }
}
