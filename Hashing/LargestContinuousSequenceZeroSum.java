/*
* Find the largest continuous sequence in a array which sums to zero.
* Example:
    Input:  {1 ,2 ,-2 ,4 ,-4}
    Output: {2 ,-2 ,4 ,-4}
* NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
*
* Approach: Create cumulative sum array where ith index in this array represents total sum from 1 to ith index element.
    * Iterate all elements of cumulative sum array and use hashing to find two elements where value at ith index == value at jth index but i != j.
    * IF element is not present in hash in fill hash table with current element.
* */

public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> sumList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        map.put(0,-1);

        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLen = -1;

        for (int i=0;i<A.size();i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                if (maxLen < (i - map.get(sum))) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLen = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }

        if (start >= 0 && end >= 0) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }

        return result;
    }
}
