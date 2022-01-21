class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] m = new boolean[V];
        boolean[] vis = new boolean[V];
        // Arrays.fill(m, false);
        
        for(int i=0; i<V; ++i){
            if(!vis[i]){
                if(dfsHelp(i, m, vis, adj)){
                    return true;
                }
            }
            // Arrays.fill(m, false);
        }
        return false;
    }
    
    public boolean dfsHelp(int x, boolean[] m, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        
        if(vis[x]==false){
            m[x] = true;
        
            for(int j : adj.get(x)){
                if(m[j]){
                    return true;
                }
                if(dfsHelp(j, m, vis, adj)){
                    return true;
                }
            }
            
            m[x] = false;
            vis[x] = true;
        }
        return false;
    }
}
