class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> ans;
    boolean[] m;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        m = new boolean[V];
        Arrays.fill(m, false);
        ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dfsHelp(i, adj);
        }

        return ans;
    }

    public void dfsHelp(int n, ArrayList<ArrayList<Integer>> adj){
        if (m[n] == false){
            ans.add(n);
            m[n] = true;

            for (int x : adj.get(n)) {
                dfsHelp(x, adj);
            }
        }
    }
}
