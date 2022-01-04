int minCoins(int coins[], int m, int n) 
	{ 
	    int t[m+1][n+1];
        
        
        for(int i=0; i<=m; ++i){
            for(int j=0; j<=n; ++j)
                t[i][j] = 0;
        }
        
        for(int i=0; i<=n; ++i){
            t[0][i] = INT_MAX-1;
        }
        
        for(int j=1; j<=n; ++j){
            if(j%coins[0] == 0)
                t[1][j] = j/coins[0];
            else
                t[0][j] = INT_MAX-1;
        }
        
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; ++j){
                if(coins[i-1] <= j){
                    t[i][j] = min(1+t[i][j-coins[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        if(t[m][n] == INT_MAX-1)
            return -1;
        return t[m][n];
	} 
