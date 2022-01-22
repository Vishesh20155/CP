class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        boolean[] includedInPath = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[S] = 0;
        int curr = S;
        
        for(int i=0; i<V; ++i){
            curr = findMin(dist, includedInPath);
            includedInPath[curr] = true;

            for(ArrayList<Integer> j : adj.get(curr)){
                if(includedInPath[j.get(0)] == false && dist[j.get(0)] > dist[curr] + j.get(1)){
                    dist[j.get(0)] = dist[curr] + j.get(1);
                }
            }
        }
        return dist;
    }

    static int findMin(int[] dist, boolean[] next){
        int minDist=Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=0; i<dist.length; ++i){
            if(next[i]==false && dist[i] < minDist){
                minIndex=i;
                minDist=dist[i];
            }
        }
        
        return minIndex;
    }
}