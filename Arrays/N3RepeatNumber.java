/*
* You’re given a read only array of n integers.
* Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
* If so, return the integer. If not, return -1.
* If there are multiple solutions, return any one.
* Example :
    Input : [1 2 3 1 1]
    Output : 1
    1 occurs 3 times which is more than 5/3 times.
* */

public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();

        if (n == 0) return -1;
        if (n == 1) return a.get(0);
        int check = n/3;

        int c1=a.get(0), c2=a.get(1), c1Count=0, c2Count=0;
        for (int num : a) {
            if (c1 == num) {
                c1Count++;
            }
            else if (c2 == num) {
                c2Count++;
            }
            else if (c1Count == 0) {
                c1 = num;
            }
            else if (c2Count == 0) {
                c2 = num;
            }
            else {
                c1Count--;
                c2Count--;
            }
        }

        c1Count = 0;
        c2Count = 0;

        for(int num : a) {
            if (num == c1) {
                c1Count++;
            }
            else if (num == c2) {
                c2Count++;
            }
        }

        if (c1Count > check) {
            return c1;
        }
        else if (c2Count > check) {
            return c2;
        }
        else {
            return -1;
        }
    }
}
