import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Directions: right, left, down, up (mapped to grid values 1-4)
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];

        // Fill cost matrix with maximum values initially
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);

        // 0-1 BFS using deque
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        cost[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int i = curr[0], j = curr[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    // Cost is 0 if current direction matches grid[i][j], otherwise 1
                    int newCost = cost[i][j] + (grid[i][j] == d + 1 ? 0 : 1);

                    if (newCost < cost[ni][nj]) {
                        cost[ni][nj] = newCost;
                        if (grid[i][j] == d + 1) {
                            dq.offerFirst(new int[]{ni, nj});
                        } else {
                            dq.offerLast(new int[]{ni, nj});
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
