/*
* Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.
* Two ways are different if there exists a chord which is present in one way and not in other.
* Return the answer modulo 109 + 7.

* Input Format: The first and the only argument contains the integer A.
* Output Format: Return an integer answering the query as described in the problem statement.
* Constraints: 1 <= A <= 1000
* Examples:
    Input 1: A = 1
    Output 1: 1
    Explanation 1:
        If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are:
        {(1-2)} only.
        So, we return 1.

    Input 2: A = 2
    Output 2: 2
    Explanation 2:
        If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
        {(1-2), (3-4)} and {(1-4), (2-3)}.
        So, we return 2.
* */

public class Solution {
    public int chordCnt(int n) {
        long dp[] = new long[n+1];
        if (n==0||n==1) {
            return 1;
        } else if (n==2) {
            return 2;
        } else if (n>2){
            dp[0]=1;
            dp[1]=1;
            dp[2]=2;
            for (int i=3;i<=n;i++) {
                dp[i]=0;
                for (int k=0;k<i;k++) {
                    dp[i]=(dp[i] + (dp[i-k-1] * dp[k])) % 1000000007;
                }
            }
        }
        return (int)(dp[n]%1000000007);
    }
}
