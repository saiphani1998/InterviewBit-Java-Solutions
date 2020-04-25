/*
* Given a column title as appears in an Excel sheet, return its corresponding column number.
* Example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
*/

public class Solution {
    public int titleToNumber(String A) {
        int number=0;
        int len =A.length();
        int temp;

        for (int i=0 ; i<len; i++){
            temp =(int)A.charAt(len-i-1) - 'A' +1 ;
            number += temp * Math.pow(26,i);
        }
        return number;
    }
}
