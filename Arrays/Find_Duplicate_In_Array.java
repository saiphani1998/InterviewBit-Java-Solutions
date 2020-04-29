/*
*Given a read only array of n + 1 integers between 1 and n,
* find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
    Sample Input:
    [3 4 1 4 1]
    Sample Output:
    1
* If there are multiple possible answers ( like in the sample case above ), output any one.
* If there is no duplicate, output -1
*
* Approach: Take a HashSet and traverse through the given array.
* Check if it contains the current element and return if it is present, if not store it.
* HashSet is taken here because lookup operation of HashSet takes O(1) time because it's underlying time DS is hashtable.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) {
                return a;
            } else {
                set.add(a);
            }
        }
        return -1;
    }
}
