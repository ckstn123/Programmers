//배달
class Solution {
    static void recursive(int[][] matrix, int[] visited, int K, int time, int sum, int end){
        // 종료부
        if(sum + time> K){
            return;
        }
        sum += time;
        visited[end] = sum;
        for(int i = 2; i<matrix.length; i++){
            if(matrix[end][i] != 0 && visited[i] > sum + matrix[end][i]){
                recursive(matrix, visited, K, matrix[end][i], sum, i);
            }
        }

    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] matrix = new int[N+1][N+1];
        int[] visited = new int[N+1];
        for(int i = 0; i<N+1; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        visited[1] = 1;
        for(int i = 0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if(matrix[a][b] == 0){
                matrix[a][b] = c;
                matrix[b][a] = c;
            }
            else {
                matrix[a][b] = Math.min(matrix[a][b] , c);
                matrix[b][a] = Math.min(matrix[b][a] , c);
            }

        }
        for(int i = 2; i<matrix.length; i++){
            if(matrix[1][i] != 0){
                recursive(matrix, visited, K, matrix[1][i], 0, i);
            }
        }
        for(int i = 1; i<visited.length; i++){
            if(visited[i] != Integer.MAX_VALUE){
                answer++;
            }
        }
        return answer;
    }
}