/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
* For example, given n = 3, a solution set is:
    "((()))", "(()())", "(())()", "()(())", "()()()"
    Make sure the returned list of strings are sorted.
* */

public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        Set<String> set = new HashSet<>();
        helper(0, 0, A, new StringBuilder(), set);
        ArrayList<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private void helper(int left, int right, int n, StringBuilder sb, Set<String> set) {
        if (left > n || right > n) {
            return;
        }
        if (left < right) {
            return;
        }

        if (left == right && left == n) {
            set.add(sb.toString());
        }

        helper(left+1, right, n, sb.append("("), set);
        sb.deleteCharAt(sb.length()-1);
        helper(left, right+1, n, sb.append(")"), set);
        sb.deleteCharAt(sb.length()-1);
    }
}
