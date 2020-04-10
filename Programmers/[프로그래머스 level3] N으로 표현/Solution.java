//N으로 표현 (어렵다 이해 더 필요)
class Solution {
    static int min = Integer.MAX_VALUE;
    static void dfs(int N, int number, int count, int num){
        if(count>8){
            return;
        }
        if(num == number){
            if(min > count){
                min = count;
            }
        }
        int temp = 0;
        for(int i = 0; i<8; i++){
            temp = temp*10 + N;
            dfs(N,number,count+1+i,num+temp);
            dfs(N,number,count+1+i,num-temp);
            dfs(N,number,count+1+i,num*temp);
            dfs(N,number,count+1+i,num/temp);
        }
    }
    public int solution(int N, int number) {

        dfs(N,number,0,0);
        if(min < 9){
            return min;
        }
        else
            return -1;
    }
}