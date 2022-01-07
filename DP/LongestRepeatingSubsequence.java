class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int dp[][] = new int [1002][1002];
        for(int i=0; i<=str.length(); ++i){
            for(int j=0; j<=str.length(); ++j){
                dp[i][j] = 0;
            }
        }
        
        for(int i=1; i<=str.length(); ++i){
            for(int j=1; j<=str.length(); ++j){
                if(str.charAt(i-1) == str.charAt(j-1) && i!=j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}
