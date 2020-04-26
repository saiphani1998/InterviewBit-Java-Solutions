/*
* Given a list of non negative integers, arrange them such that they form the largest number.
    * For example:
    Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    Note: The result may be very large, so you need to return a string instead of an integer.
* */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        ArrayList<String> list = new ArrayList<>();
        for (int x : A) {
            list.add("" + x);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });
        StringBuilder res=new StringBuilder();;
        for(String x:list)res.append(x);
        return res.toString().replaceAll("0","").length()==0?"0":res.toString();
    }
}
