// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int[][] ans = new int[m][n];  
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==0) ans[i][j]=0;
//                 else{
//                     ans[i][j] = bfs(mat,i,j);
//                 }
//             }
//         }
//         return ans; 
//     }
//     public int bfs(int[][] mat, int r, int c){
//         Queue<int[]> q = new LinkedList<>();
//         int val = 0;
//         q.add(new int[]{r,c});
//         while(!q.isEmpty()){
//             int sz = q.size();            
//             for(int k=0;k<sz;k++){
//                 int[] temp = q.remove();
//                 int i = temp[0];
//                 int j = temp[1];
//                 if(mat[i][j]==0) return val;
//                 if(i>0) q.add(new int[]{i-1,j});
//                 if(j>0) q.add(new int[]{i,j-1});
//                 if(i<mat.length-1) q.add(new int[]{i+1,j});
//                 if (j<mat[0].length-1) q.add(new int[]{i,j+1});
//             }
//             val++;
//         }
//         return val;
//     }
// }

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Initialize the queue with all 0 cells and mark 1 cells with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1; // Mark cells that need to be updated
                }
            }
        }

        // Directions for moving in the matrix
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // Explore all four directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if the cell is a 1 (not yet processed)
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && ans[newX][newY] == -1) {
                    ans[newX][newY] = ans[x][y] + 1; // Update distance
                    q.add(new int[]{newX, newY}); // Add the cell to the queue
                }
            }
        }

        return ans;
    }
}
