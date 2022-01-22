class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
//        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;

        //Relaxing the edges V-1 times
        for (int i = 0; i < V-1; i++) {
            for(ArrayList<Integer> j : adj){
                if (dist[j.get(0)] + j.get(2) < dist[j.get(1)]){
                    dist[j.get(1)] = dist[j.get(0)] + j.get(2);
                }
            }
        }


        //The next part checks for negative weight cycle. If there is it fills answer array with -1.
        // It is checked by again relaxing the edges and if any of them is less than the previous one,
        //then it is a negative weight cycle

        for(ArrayList<Integer> j : adj){
            if (dist[j.get(0)] + j.get(2) < dist[j.get(1)]){
                Arrays.fill(dist, -1);
                break;
            }

        }
        return dist;
    }
}