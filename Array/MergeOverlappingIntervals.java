package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new SortComparator<Interval>());
        Interval i1, i2;
        ArrayList<Interval> retList = new ArrayList<>();
        retList.add(intervals.get(0));
        int iter = 0;
        for (int i = 1; i < intervals.size(); i++) {
            i1 = retList.get(iter);
            i2 = intervals.get(i);
            if (i1.end > i2.start) {
                retList.get(iter).end = i1.end < i2.end ? i2.end : i1.end;
            } else {
                retList.add(new Interval(i2.start, i2.end));
                iter++;
            }
        }
        return retList;
    }

    public class SortComparator<T> implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }

    }

    public static void main(String[] args) {
        MergeOverlappingIntervals o = new MergeOverlappingIntervals();
    }
}