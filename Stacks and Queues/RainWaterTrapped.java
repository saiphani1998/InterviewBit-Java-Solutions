/*
* Given n non-negative integers representing an elevation map where the width of each bar is 1,
* compute how much water it is able to trap after raining.
* Input Format: The only argument given is integer array A.
* Output Format: Return the total water it is able to trap after raining..
* For Example
    Input 1:
        A = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output 1:
        6
    Explaination 1: <img src="http://i.imgur.com/0qkUFco.png">
    In this case, 6 units of rain water (blue section) are being trapped.
*
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int current =0; current < A.size(); current++) {
            while (!st.empty() && A.get(current) > A.get(st.peek())) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(A.get(current), A.get(st.peek())) - A.get(top);
                ans += distance * bounded_height;
            }
            st.push(current);
        }
        return ans;
    }
}
