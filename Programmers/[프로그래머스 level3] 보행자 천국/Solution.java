//보행자 천국(bfs 버전 실패)
class Solution {
    static int MOD = 20170805;
    static int result = 0;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    static void bfs(int[][] cityMap, int x, int y, int dir, int m, int n){
        if(x == m-1 && y == n-1){
            result = (result+1)%MOD;
            return;
        }
        if(cityMap[x][y] == 0){
            for(int temp = 0; temp<2; temp++){
                int dis_x = x + dx[temp];
                int dis_y = y + dy[temp];

                if(dis_x < 0 || dis_x >= m || dis_y < 0 || dis_y >= n){
                    continue;
                }
                bfs(cityMap, dis_x, dis_y, temp, m, n);
            }
        }
        else if(cityMap[x][y] == 1){
            return;
        }
        else {
            int dis_x = x + dx[dir];
            int dis_y = y + dy[dir];

            if(dis_x >= 0 && dis_x < m && dis_y >= 0 && dis_y < n){
                bfs(cityMap, dis_x, dis_y, dir, m, n);
            }
        }
    }
    public int solution(int m, int n, int[][] cityMap) {
        visited = new boolean[m][n];
        bfs(cityMap, 0, 0, 0, m, n);
        return result;
    }
}