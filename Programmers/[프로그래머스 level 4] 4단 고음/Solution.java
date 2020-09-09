class Solution {
    static int answer;
    static void solve(int count, int n){
        if(Math.pow(3,(int)(count/2)) > n)
            return;
        if(n==3){
            if(count == 2)
                answer++;
            return;
        }
        if(n>3){
            if(n%3 == 0 && count >= 2){
                solve(count-2, n/3);
            }
            solve(count+1, n-1);
        }
    }
    public int solution(int n) {
        answer = 0;
        solve(0,n);
        return answer;
    }
}