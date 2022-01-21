class Solution
{
    static int[] ans;
    static Stack<Integer> s;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ans = new int[V];
        s = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; ++i){
            if(!vis[i]){
                help(i, adj, vis);
            }
        }
        
        int i=0;
        while (!s.isEmpty())
            ans[i++] = s.pop();

        return ans;
    }

    static void help(int x, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        for (int j : adj.get(x)){
            if (!vis[j]){
                help(j, adj, vis);
            }
        }
        vis[x] = true;
        s.push(x);
    }
}
