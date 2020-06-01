/*
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
* Valid operators are +, -, *, /. Each operand may be an integer or another expression.
* Input Format: The only argument given is character array A.
* Output Format: Return the value of arithmetic expression formed using reverse Polish Notation.
* For Example:
    Input 1:
        A =   ["2", "1", "+", "3", "*"]
    Output 1:
        9
    Explaination 1:
        starting from backside:
        *: ( )*( )
        3: ()*(3)
        +: ( () + () )*(3)
        1: ( () + (1) )*(3)
        2: ( (2) + (1) )*(3)
        ((2)+(1))*(3) = 9

    Input 2:
        A = ["4", "13", "5", "/", "+"]
    Output 2:
        6
    Explaination 2:
        +: ()+()
        /: ()+(() / ())
        5: ()+(() / (5))
        1: ()+((13) / (5))
        4: (4)+((13) / (5))
        (4)+((13) / (5)) = 6
*
* Approach: Traverse through the given array and have a check of the character.
    * When you encounter a number, put it into stack
    * If you encounter an operator then pop 2 numbers on the stack, perform the operation on them and put them on the stack.
* */

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i<n; i++) {
            if ("*/-+".contains(A.get(i))) {
                int a = stack.pop();
                int b = stack.pop();
                if (A.get(i).equals("+")) {
                    stack.push(a+b);
                } else if (A.get(i).equals("-")) {
                    stack.push(b-a);
                } else if (A.get(i).equals("*")) {
                    stack.push(a*b);
                } else if (A.get(i).equals("/")) {
                    stack.push(b/a);
                }
            } else {
                stack.push(Integer.parseInt(A.get(i)));
            }
        }
        return stack.peek();
    }
}
