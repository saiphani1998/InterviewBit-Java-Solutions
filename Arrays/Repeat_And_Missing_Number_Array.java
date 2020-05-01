/*
* You are given a read only array of n integers from 1 to n.
* Each integer appears exactly once except A which appears twice and B which is missing.
* Return A and B.
* Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* Note that in your output A should precede B.
* Example:
    Input:[3 1 2 5 3]
    Output:[3, 4]
    A = 3, B = 4
* Approach:
    * Actual Sum of N integers = (n*n+1)/2 = sumof numbers in array + B(missing number) - A(repeating number)
    * Actual Sum of N integers - sumof numbers in array = B - A
    * Actual sum of squares of N int = (n*n+1*2n+1)/6 = sumof squares of numbers in array + B^2(missing number) - A^2(repeating number)
    * Actual sum of squares of N int - sumof squares of numbers in array = B^2(missing number) - A^2(repeating number)
        * (B^2-A^2) = (B-A)*(B+A)
    * B+A = (Actual sum of squares of N int - sumof squares of numbers in array)/(Actual Sum of N integers - sumof numbers in array)
    * We will now have values of B+A and B-A.
    * So A = ((B+A) + (B-A))/2 and B = B+A - A.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.size();

        long sumOfN = (((long) n) * ((long) n + 1)) / 2;
        long sumOfNSq = (((long) n) * ((long) n + 1) * ((long) 2*n + 1)) / 6;

        for (int i=0; i < n; i++) {
            sumOfN -= (long) A.get(i);
            sumOfNSq -= (long) A.get(i) * (long) A.get(i);
        }
        long sumOfMissRep = sumOfNSq/sumOfN;

        int missing = (int) (sumOfMissRep + sumOfN)/2;
        int repeated = (int) (sumOfMissRep - missing);

        res.add(repeated);
        res.add(missing);

        return res;
    }
}
