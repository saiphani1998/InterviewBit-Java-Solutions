/*
* Find the intersection of two sorted arrays.
* OR in other words,
* Given 2 sorted arrays, find all the elements which occur in both the arrays.
* Example :
    * Input 1:
        A : [1 2 3 3 4 5 6]
        B : [3 3 5]
    Output : [3 3 5]

    * Input 2:
        A : [1 2 3 3 4 5 6]
        B : [3 5]
    Output : [3 5]
*
* Approach: Since the arrays are sorted, loop through the given lists at a time
    * and compare the elements with each other
    * if both are same then add it to the result list and proceed further (i.e., increment both the pointers)
    * else increment the pointer of the list whose current element is less than the other (because,
    * there may be change that next element may be equal to that larger element.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i<A.size() && j<B.size()) {
            if (A.get(i).equals(B.get(j))) {
                resultList.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return resultList;
    }
}
