/*
* Given a collection of intervals, merge all overlapping intervals.
* For example:
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
    Make sure the returned intervals are sorted.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> resultList = new ArrayList<Interval>();

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start<= end) {
                end = Math.max(current.end, end);
            } else {
                resultList.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        resultList.add(new Interval(start, end));
        return resultList;
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval i1, Interval i2) {
        return i1.start- i2.start;
    }
}
