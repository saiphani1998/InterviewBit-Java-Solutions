/*
* Given two numbers represented as strings, return multiplication of the numbers as a string.
* Note: The numbers can be arbitrarily large and are non-negative.
* Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
* For example, given strings "12", "10", your answer should be “120”.
* NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
    We will retroactively disqualify such submissions and the submissions will incur penalties.
* */

public class Solution {
    public String multiply(String A, String B) {
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int[] calc = new int[arrA.length + arrB.length];

        for (int i=arrA.length-1; i>=0; --i) {
            for (int j=arrB.length-1; j>=0; --j) {
                calc[i + j + 1] += Character.getNumericValue(arrA[i]) * Character.getNumericValue(arrB[j]);
                calc[i + j] += calc[i + j + 1] / 10;
                calc[i + j + 1] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int c : calc) {
            sb.append(c);
        }

        String ans = sb.toString().replaceFirst("^0*", "");
        return ans.isEmpty() ? "0" : ans;
    }
}
