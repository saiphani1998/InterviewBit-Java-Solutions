/*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* Example:
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.
* Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*
* */

public class Solution {
    public int isPalindrome(String A) {
        int left = 0, right = A.length()-1;
        while(left<=right) {
            while (left < A.length() && (!(Character.isLetter(A.charAt(left)) || Character.isDigit(A.charAt(left))))) {
                left++;
            }
            while (right > 0 && (!(Character.isLetter(A.charAt(right)) || Character.isDigit(A.charAt(right))))) {
                right--;
            }
            if (left<=right) {
                if ((""+A.charAt(left)).equalsIgnoreCase(""+A.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
}
