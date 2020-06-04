/*
* You are given a string, S, and a list of words, L, that are all of the same length.
* Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
* Example :
    S: "barfoothefoobarman"
    L: ["foo", "bar"]
    You should return the indices: [0,9].
    (order does not matter).
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        if(A.length()==0 || B.size()==0) {
            return new ArrayList<Integer>();
        }
        ArrayList<String> C = new ArrayList<String>(B);
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for (int i=0, j=(B.size()*B.get(0).length()); j<=A.length(); i++,j++) {
            for (int k=i; k<j; k=k+B.get(0).length()){
                if (!C.contains(A.substring(k,k+B.get(0).length()))) {
                    break;
                }
                else {
                    C.remove(A.substring(k,k+B.get(0).length()));
                }
            }
            if (C.isEmpty()) {
                indexList.add(i);
            }
            C.clear();
            C.addAll(B);
        }
        return indexList;
    }
}
