class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i : adj.get(curr)){
                if(vis[i]) continue;
                q.add(i);
                vis[i] = true;
            }
        }
        return ans;
    }
}
