/*
* Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
* NOTE A solution will always exist. read Goldbach’s conjecture
* Example:
    Input : 4
    Output: 2 + 2 = 4
* If there are more than one solutions possible, return the lexicographically smaller solution:
    If [a, b] is one solution with a <= b,
    and [c,d] is another solution with c <= d, then
    [a, b] < [c, d]
    If a < c OR a==c AND b < d.
* */

public class Solution {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i<A;i++) {
            if(isPrime(i)) {
                if(isPrime(A-i)) {
                    list.add(i);
                    list.add(A-i);
                    break;
                }
            }
        }
        return list;
    }
    public boolean isPrime(int A) {
        for(int i = 2; i<=Math.sqrt(A); i++) {
            if(A%i == 0) {
                return false;
            }
        }
        return true;
    }
}
