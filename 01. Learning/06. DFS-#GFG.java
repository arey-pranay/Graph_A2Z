class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        ans.add(0);
        vis[0] = true;
        //explore all neighbours of n, add the uv neighbour of n to answer, mark it as visited, and call the function on that neighbour
        func(adj, ans, 0, vis);
        return ans;
    }
    public void func(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int curr, boolean[] vis){
        for(int neighbour : adj.get(curr)){
            if(vis[neighbour]) continue;
            vis[neighbour] = true;
            ans.add(neighbour);
            func(adj, ans, neighbour, vis);
        }
        return;
    }
}
