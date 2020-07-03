/*
* Given an index k, return the kth row of the Pascal’s triangle.
* Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
* Example:
    Input : k = 3
    Return : [1,3,3,1]
* NOTE : k is 0 based. k = 0, corresponds to the row [1].
* Note:Could you optimize your algorithm to use only O(k) extra space?
* */

public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        ans.add(1);
        if (A == 0) return ans;

        int count = 0;
        while (count <= A) {
            int j = 0;
            while (j <= count) {
                if (j == 0 || j == count) {
                    prev.add(1);
                }
                else {
                    prev.add(ans.get(j-1) + ans.get(j));
                }

                j++;
            }

            ans.clear();
            ans.addAll(prev);
            prev.clear();
            count++;
        }

        return ans;
    }
}
