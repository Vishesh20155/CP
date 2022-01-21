class Solution
{
    static int[] ans;
    static Queue<Integer> q, q1;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ans = new int[V];
        q = new LinkedList<>();
        q1 = new LinkedList<>();
        boolean[] vis = new boolean[V];
        int[] in = new int[V];
        for(int i=0;i<V;++i){
            for(int j : adj.get(i)){
                in[j]++;
            }
        }
        int k=0;
        
        for(int i=0; i<V; ++i){
            if(in[i]==0 && vis[i]==false){
                q.add(i);
                while(!q.isEmpty()){
                    int x = q.poll();
                    for(int j : adj.get(x)){
                        if((--in[j])==0)
                            q.add(j);
                    }
                    // System.out.println(x);
                    ans[k]=x;
                    k++;
                    vis[x]=true;
                }
            }
        }
        

        return ans;
    }
}
