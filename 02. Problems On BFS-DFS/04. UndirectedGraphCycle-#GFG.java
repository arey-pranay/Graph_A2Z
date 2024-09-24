class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        // if a node is visited already, and the current node is not parent,
        // it means that we are coming back to this element, so there is a cycle
        
        int[] parent = new int[V];
        Arrays.fill(parent,-1);
        
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        

        for(int i=0; i<V; i++)  if(!visited[i]) if(dfs(i,parent, visited, adj)) return true;
        return false;
    }
    
    public boolean dfs(int curr, int[] parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        //for all neighbours, check parent and if parent is not -1 then return true
        visited[curr] = true;

        for(int neighbour : adj.get(curr)){
            if(!visited[neighbour]){
                parent[neighbour] = curr;
                if(dfs(neighbour, parent, visited, adj)) return true;
            } else if(parent[curr] != neighbour) return true;
        }
        
        return false;
        // mark this node as the parent of its neighbours
    }
}
