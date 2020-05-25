/*
* Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
* More formally,
    G[i] for an element A[i] = an element A[j] such that
    j is maximum possible AND
    j < i AND
    A[j] < A[i]
* Elements for which no smaller element exist, consider next smaller element as -1.

* Input Format: The only argument given is integer array A.
* Output Format:
    Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
* For Example:
    * Input 1:
        A = [4, 5, 2, 10, 8]
    Output 1:
        G = [-1, 4, -1, 2, 2]
    Explaination 1:
        index 1: No element less than 4 in left of 4, G[1] = -1
        index 2: A[1] is only element less than A[2], G[2] = A[1]
        index 3: No element less than 2 in left of 2, G[3] = -1
        index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
        index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

    * Input 2:
        A = [3, 2, 1]
    Output 2:
        [-1, -1, -1]
    Explaination 2:
        index 1: No element less than 3 in left of 3, G[1] = -1
        index 2: No element less than 2 in left of 2, G[2] = -1
        index 3: No element less than 1 in left of 1, G[3] = -1
*
* Approach: Traverse thru the given array, maintain a stack where you store all the traversed elements which are less upto that point.
    * for every element, check if the stack top is less than it or not,
    * if yes, then that becomes g[i]
    * if no, then pop it out.
*  */

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<A.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(A.get(i));
        }
        return ans;
    }
}
