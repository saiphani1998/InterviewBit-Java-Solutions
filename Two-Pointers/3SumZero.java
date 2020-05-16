/*
* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.
* Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    * The solution set must not contain duplicate triplets.
    * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is: [[-1, 0, 1],[-1, -1, 2]]
* */

import java.math.BigInteger;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i=0;i<A.size()-2;i++) {
            if (i > 0 && A.get(i).equals(A.get(i-1))) continue; // To avoid duplicate triplets

            long target = -1L * (long)A.get(i); // To handle Integer overflow situation
            int j = i+1;
            int k = A.size()-1;
            while (j<k) {
                if ((long)A.get(j) + (long)A.get(k) == target) {  // To handle Integer overflow situation
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(k));
                    ans.add(temp);
                    j++;
                    k--;

                    while(j<k && A.get(j) == A.get(j-1)) {  // To avoid duplicate triplets
                        j++;
                    }
                    while(j<k && A.get(k) == A.get(k+1)) {  // To avoid duplicate triplets
                        k--;
                    }
                } else if (A.get(j) + A.get(k) > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
