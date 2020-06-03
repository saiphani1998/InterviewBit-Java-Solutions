/*
* For Given Number N find if its COLORFUL number or not
* Return 0/1

* COLORFUL number:
    A number can be broken into different contiguous sub-subsequence parts.
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different

* Example:
    N = 23
    2 3 23
    2 -> 2
    3 -> 3
    23 -> 6
    this number is a COLORFUL number since product of every digit of a sub-sequence are different.
    Output : 1
*
*
* */

public class Solution {
    public int colorful(int a) {
        String A = Integer.toString(a);
        HashSet<Integer> set = new HashSet<Integer>();
        int prod = 0;
        for(int i = 0; i < A.length(); i++) {
            prod = 1;
            for(int j = i; j < A.length(); j++ ){
                prod *= A.charAt(j)-'0';
                if(set.contains(prod))
                    return 0;
                else set.add(prod);
            }
        }
        return 1;
    }
}
