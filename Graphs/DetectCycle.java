class Solution {
    
    public boolean isCycle(int numCourses, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[numCourses];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        boolean[] m = new boolean[numCourses];
        Arrays.fill(m, false);

        for (int i = 0; i < numCourses; i++) {
            if (!m[i]){
                q.add(i);
                m[i] = true;
                while (!q.isEmpty()){
                    int x=q.poll();
                    for (int j : adj.get(x)){
                        if (m[j]){
                            if (j!=parent[x]){
                                // System.out.println(x+" "+j);
                                return true;}
                        }
                        else {
                            q.add(j);
                            parent[j] = x;
                            m[j] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
