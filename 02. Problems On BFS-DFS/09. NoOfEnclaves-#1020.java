class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Mark cells that can reach the boundary
        boolean[][] visited = new boolean[m][n];

        // Run DFS from the boundaries
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check only boundary cells
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                }
            }
        }

        // Count enclaves (cells that are 1 and not visited)
        int enclaveCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        // Check boundaries
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return; // Out of bounds
        }
        if (grid[i][j] == 0 || visited[i][j]) {
            return; // Stop if it's water or already visited
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Explore all four directions
        dfs(grid, i - 1, j, visited); // up
        dfs(grid, i + 1, j, visited); // down
        dfs(grid, i, j - 1, visited); // left
        dfs(grid, i, j + 1, visited); // right
    }
}
