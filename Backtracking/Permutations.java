/*
* Given a collection of numbers, return all possible permutations.
* Example:
    [1,2,3] will have the following permutations:

    [1,2,3]
    [1,3,2]
    [2,1,3]
    [2,3,1]
    [3,1,2]
    [3,2,1]
* NOTE:
    No two entries in the permutation sequence should be the same.
    For the purpose of this problem, assume that all the numbers in the collection are unique.
* */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        if (A == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        permutationHelper(A, resultList, new ArrayList<>());
        return resultList;
    }

    private void permutationHelper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> resultList,
                                   ArrayList<Integer> currentList) {
        if (A.size() == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            int current = A.remove(i);
            currentList.add(current);
            permutationHelper(A, resultList, currentList);
            A.add(i, new Integer(current));
            currentList.remove(currentList.remove(currentList.size() - 1));
        }
    }
}
