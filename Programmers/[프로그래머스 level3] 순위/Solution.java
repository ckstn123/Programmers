import java.util.Arrays;
//플로이드 와샬 알고리즘
//모든 정점에서 모든 정점으로 최단 거리를 구하는 방법
class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        int[][] score = new int[n+1][n+1];
        for(int i = 1; i<=n; i++) {
            Arrays.fill(score[i], 987654321);
        }
        for(int i = 1; i<=n; i++) {
            score[i][i] = 0;
        }
        for(int i = 0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            score[a][b] = 1;
        }

        //거쳐가는 노드
        for(int k = 1; k<=n; k++){
            //출발 노드
            for(int i = 1; i<=n; i++){
                //도착 노드
                for(int j = 1; j<=n; j++){
                    score[i][j] = Math.min(score[i][j], score[i][k] + score[k][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<= n; j++){
                if(i==j)
                    continue;
                if(score[i][j] == 987654321 && score[j][i] == 987654321){
                    check[i] = true;
                    break;
                }
            }
        }
        for(int i = 1; i<=n; i++){
            if(!check[i]){
                answer++;
            }
        }
        return answer;
    }
}