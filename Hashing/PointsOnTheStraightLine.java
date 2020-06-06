/*
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
Sample Input :
    (1, 1)
    (2, 2)
Sample Output : 2
You will be given 2 arrays X and Y. Each point is represented by (X[i], Y[i])
*
* */

public class Solution {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        Map<Double, Integer> map = new HashMap<>();
        int maxPoints = 0;
        if (a==null || b==null || a.size() != b.size()) {
            return maxPoints;
        }

        for (int i=0;i<a.size();i++) {
            int overlapping = 1;
            int vertical = 0;
            for (int j=i+1;j<a.size();j++) {
                if (a.get(i).equals(a.get(j))) {
                    if (b.get(i).equals(b.get(j))) {
                        overlapping++;
                    } else {
                        vertical++;
                    }
                } else {
                    double y = b.get(j) - b.get(i);
                    double x = a.get(j) - a.get(i);
                    double slope = 0.0;
                    if (!b.get(j).equals(b.get(i))) {
                        slope = 1.0*(y/x);
                    }
                    map.put(slope, map.getOrDefault(slope,0)+1);
                }
            }
            for (Double d : map.keySet()) {
                maxPoints = Math.max(maxPoints, map.get(d)+overlapping);
            }

            maxPoints = Math.max(maxPoints, vertical+overlapping);
            map.clear();
        }
        return maxPoints;
    }
}
