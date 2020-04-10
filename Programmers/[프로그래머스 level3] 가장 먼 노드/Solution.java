import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//가장 먼 노드
class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[][] matrix;
    static boolean[] visited;
    static int[] distance;

    static void bfs(int start){
        int size = matrix.length;
        queue.offer(start);//1을 시작으로 큐에 넣음
        visited[start] = true; //방문했다고 표시
        while(!queue.isEmpty()){
            start = queue.poll();
            for(int i = 2; i<size; i++){
                if(matrix[start][i] && !visited[i]){
                    visited[i] = true;
                    distance[i] = distance[start] + 1;
                    queue.offer(i);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 1;
        matrix = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i = 0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            //양방향 연결
            matrix[a][b] = true;
            matrix[b][a] = true;
        }
        bfs(1);

        Arrays.sort(distance);

        for(int i = n-1; i>0; i--){
            if(distance[n] == distance[i]){ //가장 큰 값과 같은 값이 있는지 확인
                answer++;
            }
            else
                break;
        }
        return answer;
    }
}