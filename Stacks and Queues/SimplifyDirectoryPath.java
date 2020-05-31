/*
* Given a string A representing an absolute path for a file (Unix-style).
* Return the string A after simplifying the absolute path.
* Note: Absolute path always begin with ’/’ ( root directory ).
    * Path will not have whitespace characters.

* Input Format: The only argument given is string A.
* Output Format: Return a string denoting the simplified absolue path for a file (Unix-style).
* For Example:
    Input 1:
        A = "/home/"
    Output 1:
        "/home"

    Input 2:
        A = "/a/./b/../../c/"
    Output 2:
        "/c"
*
* Approach: Split the given absolute path with '/' as delimiter
    * Now traverse through the result array and
        * if it is '..' then pop the stack.
        * else push the string into stack if it is not '.'
    * Now concatinate the strings available in the stack with by attaching '/' between ech string.
*
* */

public class Solution {
    public static Stack<String> stack;
    public static String simplifyPath(String A) {
        stack = new Stack<>();
        String[] args = A.trim().split("/");
        for (String s : args) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
            sb.insert(0, "/");
        }

        return sb.length() != 0 ? sb.toString() : "/";
    }
}
