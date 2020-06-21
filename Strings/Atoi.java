/*
* Implement atoi to convert a string to an integer.
* Example :
    Input : "9 2704"
    Output : 9
* Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
* Questions:
    * Q1. Does string contain whitespace characters before the number?
        * A. Yes
    * Q2. Can the string have garbage characters after the number?
        * A. Yes. Ignore it.
    * Q3. If no numeric character is found before encountering garbage characters, what should I do?
        * A. Return 0.
    * Q4. What if the integer overflows?
        * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
* Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
    If you do, we will disqualify your submission retroactively and give you penalty points.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        if (A.isEmpty()) {
            return 0;
        }
        String[] strs = A.split("\\s+");
        boolean signFlag = true;
        if (!strs[0].isEmpty() && strs[0].charAt(0) == '-') {
            signFlag = false;
        }

        char[] nums = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder("");
        int firstChar = 0;

        for (char num : nums) {
            if (Character.isDigit(num)) {
                firstChar = 1;
                sb.append(num);
            } else if (firstChar == 0 && (num == '+' || num == '-')) {
                firstChar = 1;
                continue;
            } else {
                break;
            }
        }

        if (sb.length() == 0) {
            return 0;
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
            ans *= signFlag == true ? 1 : -1;
        } catch (Exception e) {
            if (signFlag) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = Integer.MIN_VALUE;
            }
        }

        return ans;
    }
}
