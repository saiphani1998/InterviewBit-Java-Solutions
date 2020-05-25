/*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) – Push element x onto stack.
    pop() – Removes the element on top of the stack.
    top() – Get the top element.
    getMin() – Retrieve the minimum element in the stack.
* Note that all the operations have to be constant time operations.
*
* Approach: Keep maintaining a min stack whose top element is the min element of the original stack.
    * When pop is done, if the top element of original stack is same as the top element of min stack, then pop both. Else pop original stack only.
    * When top is asked, return the top element of original stack.
    * When minimum element is asked, return the top element of min stack.
* */

class Solution {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int num = stack.pop();
            if(num == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
