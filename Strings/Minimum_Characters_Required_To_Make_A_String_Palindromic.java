/*
* Given an string A. The only operation allowed is to insert characters in the beginning of the string.
* Find how many minimum characters are needed to be inserted to make the string a palindrome string.
* Input Format: The only argument given is string A.
* Output Format: Return the minimum characters that are needed to be inserted to make the string a palindrome string.
* For Example:
    Input 1:
        A = "ABC"
    Output 1:
        2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

    Input 2:
        A = "AACECAAAA"
    Output 2:
        2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".
*
* Approach: Keep prefixing the trailing characters in reverse relative order and check if every new string is palindrome or not
    and keep counting the number of checks done.
    * Explanation: Given string 'XYZ'
    * 1st iteration: Check if XYZ is palindrome or not (No) count = 0;
    * 2nd iteration: Check if ZXYZ is palindrome or not (No) Count = 1
    * 3rd iteration: Check if ZYXYZ is palindrome or not (Yes) Count = 2
    * So answer is 2.
* */

public class Solution {
    public int solve(String A) {
        int start = 0;
        int end = 0;
        int count = 0;
        String reverseString = new StringBuilder(A).reverse().toString();

        while (true) {
            if (isPalindrome(reverseString.substring(start, end)+ A)) break;
            end++;
            count++;
        }

        return count;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
