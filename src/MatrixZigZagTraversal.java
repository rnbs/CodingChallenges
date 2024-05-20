import java.util.*;

/**
 * @author: Santosh RNB
 * @created: 5/19/24
 */
public class MatrixZigZagTraversal {
    public void matrixZigZagTraversal(int[][] matrix) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        boolean isReverse = false;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            List<int[]> levelOrder = new ArrayList<>();
            for(int i = 0; i < currSize; i++) {
                int[] currPosition = queue.poll();
                int currRow = currPosition[0];
                int currCol = currPosition[1];

                if(currRow < 0 || currRow >= ROWS || currCol < 0 || currCol >= COLS) {
                    continue;
                }

                if(isReverse) {
                    levelOrder.add(currPosition);
                } else{
                    levelOrder.add(0, currPosition);
                }

                if(currRow +1 >= 0 && currRow + 1 < ROWS && (!visited[currRow+1][currCol])) {
                    queue.add(new int[] {currRow + 1, currCol});
                    visited[currRow+1][currCol] = true;
                }
                if(currCol +1 >= 0 && currCol + 1 < COLS && (!visited[currRow][currCol+1])) {
                    queue.add(new int[] {currRow, currCol + 1});
                    visited[currRow][currCol+1] = true;
                }
            }

            isReverse = !isReverse;

            levelOrder.stream().forEach(x -> {
                System.out.println(matrix[x[0]][x[1]]);
            });

        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1, 2, 3, 4 },
                { 5, 6, 7, 8, 9 },
                { 10, 11, 12, 13, 14 },
                { 15, 16, 17, 18, 19 },
                { 20, 21, 22, 23, 24 }
        };
        MatrixZigZagTraversal matrixZigZagTraversal = new MatrixZigZagTraversal();
        matrixZigZagTraversal.matrixZigZagTraversal(matrix);
    }
}
