class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        int initial = image[sr][sc];
        if(initial == color) return image;
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];
                if(r > 0 && image[r-1][c]==initial){
                    image[r-1][c] = color;
                    q.add(new int[]{r-1,c}); 
                }
                if(r < image.length-1 && image[r+1][c]==initial){
                    image[r+1][c] = color;
                    q.add(new int[]{r+1,c}); 
                }
                if(c > 0 && image[r][c-1]==initial){
                    image[r][c-1] = color;
                    q.add(new int[]{r,c-1}); 
                }
                if(c < image[0].length - 1 && image[r][c+1]==initial){
                    image[r][c+1] = color;
                    q.add(new int[]{r,c+1}); 
                }
            }
        }
        return image;
    }
}
