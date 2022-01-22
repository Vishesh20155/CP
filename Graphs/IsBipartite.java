class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean[] inTree = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        boolean lev = true;

        for(int i=0; i<v; ++i){
            if(!vis[i]){
                q.add(i);
                vis[i] = true;
                inTree[i] = !lev;
                q.add(-1);
                while(q.size()>1){
                    int f = q.poll();
                    if(f!=-1){
                        for(int j : graph[f]){
                            if(vis[j]){
                                if(inTree[j] == inTree[f])
                                    return false;
                            }
                            else{
                                q.add(j);
                                vis[j]=true;
                                inTree[j] = lev;
                            }
                        }
                    }
                    else{
                        q.add(-1);
                        lev = !lev;
                    }
                }
                q.poll();
            }
        }
        return true;
    }
}
