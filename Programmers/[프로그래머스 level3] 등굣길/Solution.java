//등굣길
class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i = 0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            dp[x][y] = -1;
        }
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(j == 1 && i == 1)
                    continue;
                if(dp[j][i] == -1){
                    dp[j][i] = 0;
                    continue;
                }
                dp[j][i] = (dp[j-1][i] + dp[j][i-1]) % 1000000007;
            }
        }
        return dp[m][n];
    }
}