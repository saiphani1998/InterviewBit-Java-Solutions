/*
* Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”,
* you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first).
* We define the “Goodness Value” of a string as the number of “Good Words” in that string.
* Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.
* You are expected to use Trie in an Interview for such problems
* Constraints:
    1.   1 <= No.of reviews <= 200
    2.   1 <= No. of words in a review <= 1000
    3.   1 <= Length of an individual review <= 10,000
    4.   1 <= Number of Good Words <= 10,000
    5.   1 <= Length of an individual Good Word <= 4
    6.   All the alphabets are lower case (a - z)
* Input:
    S : A string S containing "Good Words" separated by  "_" character. (See example below)
    R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
* Output:
    A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.
    V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
    In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
* Example:
    Input:
        S = "cool_ice_wifi"
        R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
    Output:
        ans = [2, 0, 1]
        Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
* */

public class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        TrieNode head = new TrieNode();
        TrieNode t = new TrieNode();

        String[] input = A.split("_");

        for(String temp: input){
            t.insert(head,temp);
        }

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<B.size();i++){

            int count = 0;
            input = B.get(i).split("_");
            for(String temp : input){
                if(t.search(head,temp)){
                    count++;
                }
            }

            if(!treeMap.containsKey(count)){
                treeMap.put(count, new ArrayList<>());
            }
            treeMap.get(count).add(i);
        }

        for(int j=treeMap.lastKey();j>=treeMap.firstKey();j--){

            if(treeMap.containsKey(j)){
                result.addAll(treeMap.get(j));
            }
        }

        return result;
    }

    class TrieNode{

        boolean isEnd;
        Map<Character,TrieNode> map;

        public TrieNode(){
            map = new HashMap<>();
            isEnd = false;
        }

        public void insert(TrieNode head, String s){

            TrieNode cur = head;
            for(int i=0;i<s.length();i++){
                if(!cur.map.containsKey(s.charAt(i))){
                    cur.map.put(s.charAt(i), new TrieNode());
                }
                cur = cur.map.get(s.charAt(i));
            }

            cur.isEnd = true;
        }

        public boolean search(TrieNode head, String s){
            if(head == null){
                return false;
            }
            TrieNode cur = head;
            for(int i=0;i<s.length();i++){
                if(!cur.map.containsKey(s.charAt(i))){
                    return false;
                }
                cur = cur.map.get(s.charAt(i));
            }

            return cur.isEnd;
        }
    }
}
