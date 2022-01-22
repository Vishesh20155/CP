class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        
        for(int i=0; i<v; ++i){
            if(vis[i]==0){
                vis[i] = 1;
                // System.out.println(i + " " + vis[i]);
            }
            if(dfsHelp(i, graph, vis)==false)
                return false;
        }

        return true;
    }
    
    public boolean dfsHelp(int x, int[][] graph, int[] vis){
        
        for(int j : graph[x]){
            if(vis[j]!=0){
                if(vis[j] == vis[x]){
                    // System.out.println(x + " " + j);
                    return false;
                }
            }
            else{
                vis[j] = 3-vis[x];
                // System.out.println(x + " " + j + " " + vis[j]);
                dfsHelp(j, graph, vis);
            }
        }
        return true;
    }
}
