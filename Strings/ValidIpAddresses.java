/*
* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
* A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
* Example:
    Given “25525511135”,
    return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
* */

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (len > 12) {
            return res;
        }

        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);

                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }

        return res;
    }

    public static boolean isValid(String s){
        if(s.length()>3 || s.isEmpty() || s.charAt(0)=='0' && s.length()>1 || Integer.parseInt(s)>255) {
            return false;
        }
        return true;
    }
}
