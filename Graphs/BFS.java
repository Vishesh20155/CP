class Solution {
    ArrayList<Integer> ans;
    Queue<Integer> q;
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        q = new LinkedList<>();
        boolean[] m = new boolean[V];
        Arrays.fill(m, false);
        q.add(0);
        
        while(!q.isEmpty()){
            int x = q.poll();
            
            ans.add(x);
            m[x] = true;
            for (int i : adj.get(x)) {
                if (m[i] == false){
                    q.add(i);
                    m[i] = true;
                }
            }
        }
        
        return ans;
    }

    public void dfsHelp(int n, ArrayList<ArrayList<Integer>> adj){
        
    }
}
