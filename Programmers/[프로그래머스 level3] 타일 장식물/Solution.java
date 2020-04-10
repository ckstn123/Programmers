//타일 장식물
class Solution {
    public long solution(int N) {

        long[] dp = new long[N+1];
        dp[1] = 4;
        dp[2] = 6;
        dp[3] = 10;
        for(int i = 4; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}