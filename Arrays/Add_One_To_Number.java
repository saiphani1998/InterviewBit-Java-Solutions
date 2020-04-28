/*
* Given a non-negative number represented as an array of digits,
* add 1 to the number ( increment the number represented by the digits ).
* The digits are stored such that the most significant digit is at the head of the list.
* Example:
    If the vector has [1, 2, 3]
    the returned vector should be [1, 2, 4]
    as 123 + 1 = 124.
* NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example, for this problem, following are some good questions to ask :
    Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
    A : For the purpose of this question, YES
    Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
    A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*
* */

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int overflow = 1, i = A.size()-1;
        while (overflow!=0 && i>=0) {
            int currentSum = A.get(i) + overflow;
            overflow = currentSum>9 ? 1 : 0;
            A.set(i,currentSum%10);
            i--;
        }

        // To handle the scenerio when the given list is all 9's
        if (overflow != 0) {
            // Insert 1 at MSB position. i.e., at 0 index
            A.add(0,1);
        }

        // To find the index of Most Significant Bit
        i = 0;
        while ( i<A.size() && A.get(i) == 0) {
            i++;
        }
        ArrayList<Integer> returnList = new ArrayList<>();
        // To return the list from the MSB,i.e., by removing the 0's in the start of list.
        returnList.addAll(A.subList(i,A.size()));
        return returnList;
    }
}
