class Solution {
    class Node{
        int r, c;
        public Node(int _x, int _y){
            r = _x;
            c = _y;
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans=0;
        Queue<Node> q = new LinkedList<>();
        
        boolean[][] m = new boolean[rows][cols];
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(!m[i][j] && grid[i][j]=='1'){
                    q.add(new Node(i, j));
                    m[i][j] = true;
                    ans++;
                }
                while(!q.isEmpty()){
                    Node t = q.poll();
                    boolean island = true;
                    
                    if(t.r!=0 && grid[t.r-1][t.c]=='1'){
                        if(m[t.r-1][t.c]==false){
                            q.add(new Node(t.r-1, t.c));
                            island = false;
                            m[t.r-1][t.c] = true;
                        }
                    }
                    if(t.r!=(rows-1) && grid[t.r+1][t.c]=='1'){
                        if(m[t.r+1][t.c]==false){
                            q.add(new Node(t.r+1, t.c));
                            island = false;
                            m[t.r+1][t.c]=true;
                        }
                    }
                    if(t.c!=0 && grid[t.r][t.c-1]=='1'){
                        if(m[t.r][t.c-1]==false){
                            q.add(new Node(t.r, t.c-1));
                            island = false;
                            m[t.r][t.c-1]=true;
                        }
                    }
                    if(t.c!=(cols-1) && grid[t.r][t.c+1]=='1'){
                        
                        if(m[t.r][t.c+1]==false){
                            q.add(new Node(t.r, t.c+1));
                            island = false;
                            m[t.r][t.c+1]=true;
                        }
                    }
                    
                }
            }
        }
        
        return ans;        
    }
}
