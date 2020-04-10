import java.util.LinkedList;
import java.util.Queue;

//블록 이동하기(어렵다 이해 더 필요)
class Solution {
    static int[] dx = {1, 0, -1, 0};//우하좌상
    static int[] dy = {0, 1, 0, -1};
    static int[] rdx = {1, 1, -1, -1};//회전 방향
    static int[] rdy = {-1, 1, 1, -1};
    static Queue<robot> queue = new LinkedList<>();

    static class robot{
        int x,y,dir,time;

        robot(int x, int y, int dir, int time){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }
    }

    static boolean check(int x1, int y1, int n){
        if(x1 < 0 || x1 > n || y1 < 0 || y1 > n){
            return false;
        }
        return true;
    }
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length-1;
        int[] rotation = {1,3};
        boolean[][][] visited = new boolean[n+1][n+1][4];
        queue.offer(new robot(0,0,0,0));
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            robot temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            int time = temp.time;
            int dir = temp.dir;
            int second_x = x + dx[dir];
            int second_y = y + dy[dir];

            if(x == n && y == n)
                return time;
            if(second_x == n && second_y == n)
                return time;

            int dis_x;
            int dis_y;
            int dis_second_x;
            int dis_second_y;
            for(int i = 0; i<4; i++){
                dis_x = x + dx[i];
                dis_y = y + dy[i];
                dis_second_x = second_x + dx[i];
                dis_second_y = second_y + dy[i];

                if(!check(dis_x,dis_y,n) || !check(dis_second_x,dis_second_y,n)){
                    continue;
                }
                if(board[dis_y][dis_x] == 0 && board[dis_second_y][dis_second_x] == 0 && !visited[dis_y][dis_x][dir]){
                    visited[dis_y][dis_x][dir] = true;
                    queue.offer(new robot(dis_x, dis_y,dir,time+1));
                }
            }
            for(int r : rotation){
                int rdir = (dir+r)%4;
                dis_x = x + dx[rdir];
                dis_y = y + dy[rdir];

                if(r == 1){
                    dis_second_x = x + rdx[rdir];
                    dis_second_y = y + rdy[rdir];
                }
                else{
                    dis_second_x = x + rdx[dir];
                    dis_second_y = y + rdy[dir];
                }
                if(!check(dis_x, dis_y, n) || !check(dis_second_x, dis_second_y, n))
                    continue;
                if(visited[y][x][rdir])
                    continue;
                if(board[dis_y][dis_x] == 1 || board[dis_second_y][dis_second_x] == 1)
                    continue;

                visited[y][x][rdir] = true;
                queue.offer(new robot(x,y,rdir, time+1));
            }

            dir = (dir+2)%4;
            for(int r : rotation){
                int rdir = (dir+r)%4;
                dis_x = second_x + dx[rdir];
                dis_y = second_y + dy[rdir];

                if(r == 1){
                    dis_second_x = second_x + rdx[rdir];
                    dis_second_y = second_y + rdy[rdir];
                }
                else{
                    dis_second_x = second_x + rdx[dir];
                    dis_second_y = second_y + rdy[dir];
                }

                if(!check(dis_x, dis_y, n) || !check(dis_second_x, dis_second_y, n))
                    continue;

                if(board[dis_y][dis_x] == 1 || board[dis_second_y][dis_second_x] == 1)
                    continue;
                rdir = (rdir+2)%4;

                if(visited[dis_y][dis_x][rdir])
                    continue;
                visited[dis_y][dis_x][rdir] = true;
                queue.offer(new robot(dis_x,dis_y,rdir, time+1));
            }
        }
        return answer;
    }
}