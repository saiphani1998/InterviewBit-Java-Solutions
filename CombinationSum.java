/*
* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
* The same repeated number may be chosen from C unlimited number of times.
* Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The combinations themselves must be sorted in ascending order.
    CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
    The solution set must not contain duplicate combinations.
* Example,
    Given candidate set 2,3,6,7 and target 7,
    A solution set is:
        [2, 2, 3]
        [7]
* */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A.size() == 0) {
            return ans;
        }
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<>();
        combinationSumHelper(A, B, ans, temp, 0);
        return ans;
    }

    private void combinationSumHelper(ArrayList<Integer> a, int b,
        ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int start) {
        if (b < 0) {
            return;
        }
        if (b == 0) {
            if (!ans.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
        } else {
            for (int i = start; i < a.size(); i++) {
                temp.add(a.get(i));
                combinationSumHelper(a, b - a.get(i), ans, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
