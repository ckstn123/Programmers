class Solution2 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] dp_x = new int[m+1][n+1];
        int[][] dp_y = new int[m+1][n+1];

        dp_x[1][1] = dp_y[1][1] = 1;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(cityMap[j-1][i-1] == 0){
                    dp_x[j][i] = (dp_x[j][i] + dp_x[j-1][i] + dp_y[j][i-1]) % MOD;
                    dp_y[j][i] = (dp_y[j][i] + dp_x[j-1][i] + dp_y[j][i-1]) % MOD;
                }
                else if(cityMap[j-1][i-1] == 1){
                    dp_x[j][i] = 0;
                    dp_y[j][i] = 0;
                }
                else {
                    dp_x[j][i] = dp_x[j-1][i];
                    dp_y[j][i] = dp_y[j][i-1];

                }
            }
        }
        answer = (dp_x[m-1][n] + dp_y[m][n-1]) % MOD;
        return answer;
    }
}