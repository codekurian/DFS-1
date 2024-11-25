// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Problem2 {
    private
    int m;

    private
    int n;

    public
    int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;

        // edge case

        if (matrix == null || m == 0) return matrix;

        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});

                } else {
                    matrix[i][j] = Integer.MAX_VALUE;  //
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int r = dir[0] + curr[0];

                    int c = dir[1] + curr[1];

                    if (r >= 0 && r < m && c >= 0 && c < n &&
                            matrix[r][c] > matrix[curr[0]][curr[1]] + 1) {
                        q.add(new int[]{r, c});

                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }

        return matrix;
    }
}
