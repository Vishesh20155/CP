class Solution
{
    Stack<Integer> s;
    boolean[] vis;
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        s = new Stack<>();
        vis = new boolean[V];
        
        //FIRST get a topological sort of a graph
        for(int i=0; i<V; ++i){
            if(!vis[i]){
                dfsHelp(i, adj);
            }
        }
        // System.out.println(s);
        
        //SECOND get the transpose of the graph. i.e. reverse all edges
        ArrayList<ArrayList<Integer>> tra = new ArrayList<>();
        for(int i=0; i<V; ++i){
            tra.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; ++i){
            for(int j:adj.get(i)){
                tra.get(j).add(i);
            }
        }
        
        //THIRD do the DFS as per the finishing times
        int ans=0;
        while(!s.isEmpty()){
            int y = s.pop();
            if(vis[y]){
                dfsHelp2(y, tra);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void dfsHelp(int x, ArrayList<ArrayList<Integer>> adj){
        vis[x] = true;
        for(int j : adj.get(x)){
            if(!vis[j]){
                dfsHelp(j, adj);
            }
        }
        s.push(x);
    }
    
    public void dfsHelp2(int x, ArrayList<ArrayList<Integer>> adj){
        vis[x] = false;
        for(int j : adj.get(x)){
            if(vis[j]){
                dfsHelp2(j, adj);
            }
        }
        // s.push(x);
    }
}
