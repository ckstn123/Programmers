//경주로 건설
class Solution {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};//우하좌상
    static int[] dy = {0,1,0,-1};
    static int[][] dist;
    static void bfs(int x, int y, int[][] board, int cost, int n, int dir){

        if(min <= cost){
            return;
        }
        if(x == n-1 && y == n-1){
            min = cost;
            return;
        }
        for(int i = 0; i<4; i++){
            int dis_x = x + dx[i];
            int dis_y = y + dy[i];

            //범위를 벗어나거나 벽이 있거나 후진하는 경우
            if(dis_x < 0 || dis_x >= n || dis_y < 0 || dis_y >= n || board[dis_y][dis_x] == 1 || dir == (i+2)%4){
                continue;
            }
            int temp_cost = 100;
            //진행방향과 다른 방향이면 코너를 만든다.
            if(i != dir){
                temp_cost += 500;
            }
            //아직 비용이 정해지지 않았다면
            if(dist[dis_y][dis_x] == 0){
                dist[dis_y][dis_x] = cost + temp_cost;
                bfs(dis_x, dis_y, board, cost+temp_cost, n, i);
            }
            else { //비용이 정해졌다면
                //현재 비용과 새로운 비용을 비교해서 현재 비용이 더 높다면
                if(dist[dis_y][dis_x] >= cost+temp_cost){
                    dist[dis_y][dis_x] = cost+temp_cost;
                    bfs(dis_x, dis_y, board, cost+temp_cost, n, i);
                }
            }

        }
    }
    public int solution(int[][] board) {
        dist = new int[board.length][board.length];
        bfs(0,0,board,0,board.length,0);
        bfs(0,0,board,0,board.length,1);
        return min;
    }
}