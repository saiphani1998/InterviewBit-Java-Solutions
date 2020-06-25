/*
* Given a string S, find the longest palindromic substring in S.
* Substring of string S: S[i...j] where 0 <= i <= j < len(S)
* Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
* Incase of conflict, return the substring which occurs first ( with the least starting index ).
* Example :
    Input : "aaaabaaa"
    Output : "aaabaaa"
* */

public class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i=0;i<s.length();i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
