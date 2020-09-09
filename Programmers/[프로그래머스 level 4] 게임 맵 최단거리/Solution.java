import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class point{
        int x, y, count;
        point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(0,0,1));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            if(temp.x == maps[0].length-1 && temp.y == maps.length-1){
                answer = temp.count;
                break;
            }
            for(int i = 0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x < 0 || x >= maps[0].length || y < 0 || y >= maps.length || visited[y][x] || maps[y][x] == 0)
                    continue;
                visited[y][x] = true;
                queue.offer(new point(x,y,temp.count+1));
            }
        }
        if(answer == 0)
            return -1;
        return answer;
    }
}