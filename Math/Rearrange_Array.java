/*
* Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
*/

public class Solution {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for(int i = 0; i<n; i++) {
            a.set(i,a.get(i)+ (a.get(a.get(i))%n)*n);
        }
        for(int i = 0; i<n; i++) {
            a.set(i,a.get(i)/n);
        }
    }
}
