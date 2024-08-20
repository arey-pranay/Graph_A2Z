class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) adj.add(new ArrayList<Integer>());
        
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
        
    }
}
