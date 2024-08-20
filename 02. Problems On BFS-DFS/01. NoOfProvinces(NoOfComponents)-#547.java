class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = isConnected.length;
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    // adj.get(b).add(a);
                }
            }
        }
        System.out.println(adj);
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
        bfs(adj, V, ans, 0, visited);
        while(ans.size() != V){
            for(int i=0;i<V;i++){
                if(visited[i]==false){
                    count++;
                    bfs(adj, V, ans, i, visited);
                }
            }
            System.out.println(count);
        }
        return count;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adj, int V, ArrayList<Integer> ans, int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i : adj.get(curr)){
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}