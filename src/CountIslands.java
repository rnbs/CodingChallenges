import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Santosh RNB
 * @created: 5/19/24
 */
public class CountIslands {
    public int countIslandsUsingBFS(int[][] matrix) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        int count = 0;
        for(int i = 0; i< ROWS; i++) {
            for(int j = 0; j< COLS; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    count ++;
                    visitMatrixBFS(matrix, visited, i, j);
                }
            }
        }
        return count;
    }

    public int countIslandsUsingDFS(int[][] matrix) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(matrix[i][j] ==1 && !visited[i][j]) {
                    count++;
                    visitMatrixDFS(matrix, visited, i, j);
                }
            }
        }
        return count;
    }

    public void visitMatrixDFS(int[][] matrix, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if(matrix[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        visitMatrixDFS(matrix, visited, i+1, j);
        visitMatrixDFS(matrix, visited, i-1, j);
        visitMatrixDFS(matrix, visited, i, j+1);
        visitMatrixDFS(matrix, visited, i, j-1);
    }

    public void visitMatrixBFS(int[][] matrix, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] currPosition = queue.poll();
            int currRow = currPosition[0];
            int currCol = currPosition[1];

            if(currRow < 0 || currRow >= matrix.length || currCol < 0 || currCol >= matrix[0].length) {
                continue;
            }

            if(matrix[currRow][currCol] == 0 || visited[currRow][currCol]) {
                continue;
            }

            visited[currRow][currCol] = true;

            queue.add(new int[] {currRow, currCol +1});
            queue.add(new int[] {currRow, currCol -1});
            queue.add(new int[] {currRow + 1, currCol});
            queue.add(new int[] {currRow - 1, currCol});
        }
    }

    public static void main(String[] args) {
        CountIslands countIslands = new CountIslands();
        int[][] matrix1 = new int[][] {
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 0 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };

        int[][] matrix2 = new int[][] {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        int bfsResult = countIslands.countIslandsUsingBFS(matrix1);

        int bfsResult2 = countIslands.countIslandsUsingBFS(matrix2);


        System.out.println(bfsResult + " " + bfsResult2);

        int dfsResult = countIslands.countIslandsUsingDFS(matrix1);

        int dfsResult2 = countIslands.countIslandsUsingDFS(matrix2);

        System.out.println(dfsResult + " " + dfsResult2);
    }
}
