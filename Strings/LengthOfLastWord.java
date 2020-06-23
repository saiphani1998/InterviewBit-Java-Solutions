/*
* Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
* return the length of last word in the string.
* If the last word does not exist, return 0.
* Note: A word is defined as a character sequence consists of non-space characters only.
* Example:
    Given s = "Hello World",
    return 5 as length("World") = 5.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String[] words = A.split(" ");
        return words.length > 0 ? words[words.length - 1].length() : 0;
    }
}
