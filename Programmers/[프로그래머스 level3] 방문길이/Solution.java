//방문 길이
class Solution {

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;//초기 위치
        int y = 5;//초기 위치
        for(int i = 0; i<dirs.length(); i++){
            if(dirs.charAt(i) == 'U'){//방향이 위일 경우
                if(y+1 > 10){//y좌표가 범위를 벗어나면
                    continue;
                }
                if(!visited[x][y][0]){//아직 가지않은 경로라면
                    answer++;
                }
                visited[x][y][0] = true;//해당 위치에서 위 방향 경로를 표시
                y++;
                visited[x][y][1] = true;//위로 한칸 가서 아래 방향 경로를 표시
            }
            if(dirs.charAt(i) == 'D'){
                if(y-1 < 0){
                    continue;
                }
                if(!visited[x][y][1]){
                    answer++;
                }
                visited[x][y][1] = true;
                y--;
                visited[x][y][0] = true;
            }
            if(dirs.charAt(i) == 'R'){
                if(x+1 > 10){
                    continue;
                }
                if(!visited[x][y][2]){
                    answer++;
                }
                visited[x][y][2] = true;
                x++;
                visited[x][y][3] = true;
            }
            if(dirs.charAt(i) == 'L'){
                if(x-1 < 0){
                    continue;
                }
                if(!visited[x][y][3]){
                    answer++;
                }
                visited[x][y][3] = true;
                x--;
                visited[x][y][2] = true;
            }
        }
        return answer;
    }
}