class Solution {
    public int orangesRotting(int[][] grid) {
        // a function to check and mark 4 directions
        // note visited oranges in a 2D boolean array
        // if any orange makes other orange rotten, do time++;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2)  q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int k = 0; k < size; k++) {
                int[] curr = q.remove();
                int i = curr[0];
                int j = curr[1];
                if(i > 0 && grid[i-1][j] == 1){
                    q.add(new int[]{i-1,j});
                    grid[i-1][j] = 2;
                    flag = true;
                }
                if(i < m-1 && grid[i+1][j] == 1){
                    q.add(new int[]{i+1,j});
                    grid[i+1][j] = 2;
                    flag = true;
                }
                if(j > 0 && grid[i][j-1] == 1){
                    q.add(new int[]{i,j-1});
                    grid[i][j-1] = 2;
                    flag = true;
                }
                if(j < n-1 && grid[i][j+1] == 1){
                    q.add(new int[]{i,j+1});
                    grid[i][j+1] = 2;
                    flag = true;
                }
            }
            if(flag) count++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return count;

        // if neighbour is not visited and neighbour is 1, then flag and make neighbour 2, and at the end of for loop, check for flag and increment count
    }
}
