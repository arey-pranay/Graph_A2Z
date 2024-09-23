class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited  = new boolean[V];
        int components = 0;
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i,adj, visited);
                components++;
            }
        }
        return components;
    }
    static void dfs(int current, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[current] = true;
        for(int i=0; i<adj.get(current).size(); i++){
            if(!visited[i] && adj.get(current).get(i)==1){
                dfs(i,adj,visited);
            }
        }
        return;
    }
};
