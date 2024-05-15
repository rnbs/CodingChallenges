import java.util.*;

public class LC_56_MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || ((LinkedList<int[]>) merged).getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                ((LinkedList<int[]>) merged).getLast()[1] = Math.max(
                        ((LinkedList<int[]>) merged).getLast()[1],
                        interval[1]
                );
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals(intervals);
        Arrays.stream(result).forEach(x -> System.out.println(x[0] + " " + x[1]));
    }

}
