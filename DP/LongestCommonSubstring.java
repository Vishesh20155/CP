class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
           dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
           dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int maxi = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(dp[i][j] > maxi)
                maxi = dp[i][j];
            }
        }
        return maxi;
    }
}
