/*
* Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
* The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
* Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
* Find and return the required subarray.
*/

import java.math.*;
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger prev=BigInteger.valueOf(Integer.MIN_VALUE);
        ArrayList pal=new ArrayList();
        ArrayList al = new ArrayList();
        for(int i=0;i<A.size();i++){
            if((int)A.get(i)>=0){
                al.add(A.get(i));
                sum=sum.add(BigInteger.valueOf(A.get(i)));
            }else{
                if(sum.compareTo(prev)==1){
                    pal=new ArrayList(al);
                    prev=sum;
                }
                al.clear();
                sum=BigInteger.ZERO;
            }
        }
        if(sum.compareTo(prev)==1){
            pal=new ArrayList(al);
            al.clear();
            prev=sum;
        }
        return pal;
    }
}
