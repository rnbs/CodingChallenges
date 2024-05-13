import java.util.Arrays;
import java.util.Comparator;

public class LC_56_MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        int[][] result = new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] interval : intervals) {
            for(int i =1; i < interval.length; i++) {
                int currStart = interval[0];
                int currEnd = interval[1];

                if(currStart <= end) {
                    end = Math.max(currEnd, end);
                } else {
                    result.add(new int[]{currStart, currEnd});
                }

            }
        }
    }

}
