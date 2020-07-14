/*
* You are given an array of N integers, A1, A2 ,..., AN and an integer B.
* Return the of count of distinct numbers in all windows of size B.

* Formally, return an array of size N-B+1 where i'th element in this array contains
* number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

* NOTE: if B > N, return an empty array.

* Input Format
    First argument is an integer array A
    Second argument is an integer B.
* Output Format: Return an integer array.

* Example Input:
    * Input 1:
        A = [1, 2, 1, 3, 4, 3]
        B = 3
    * Input 2:
        A = [1, 1, 2, 2]
        B = 1
* Example Output
    Output 1: [2, 3, 3, 2]
    Output 2: [1, 1, 1, 1]
* Example Explanation
    * Explanation 1:
        A=[1, 2, 1, 3, 4, 3] and B = 3
        All windows of size B are
        [1, 2, 1]
        [2, 1, 3]
        [1, 3, 4]
        [3, 4, 3]
        So, we return an array [2, 3, 3, 2].
    * Explanation 2: Window size is 1, so the output array is [1, 1, 1, 1].
* */

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (B > A.size()) {
            return resultList;
        }

        Map<Integer,Integer> map = new HashMap<>();
        int distinct = 0;
        int i = 0;
        while (i<B) {
            int value = A.get(i);
            if (map.containsKey(value)) {
                map.put(value,map.get(value)+1);
            } else {
                map.put(value,1);
                distinct++;
            }
            i++;
        }

        resultList.add(distinct);

        while (i<A.size()) {
            int value = A.get(i-B);
            int count = map.getOrDefault(value,0);

            if (count==1) {
                map.put(value,0);
                distinct--;
            } else if (count > 1) {
                map.put(value,count-1);
            }

            value = A.get(i);
            count = map.getOrDefault(value,0);
            if (count == 0) {
                distinct++;
            }
            map.put(value,count+1);

            resultList.add(distinct);
            i++;
        }

        return resultList;
    }
}
