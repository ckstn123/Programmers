import java.util.Arrays;

//기둥과 보 설치
class Solution {
    static structure[][] matrix;
    static class structure{
        int x,y,pillar,beam;
        structure(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean pillar_check(int x, int y){
        if(y == 1 || matrix[x-1][y].beam == 1 || matrix[x][y].beam == 1 || matrix[x][y-1].pillar == 1){
            return true;
        }
        return false;
    }
    static boolean beam_check(int x, int y){
        if (matrix[x][y - 1].pillar == 1 || matrix[x + 1][y - 1].pillar == 1 || (matrix[x - 1][y].beam == 1 && matrix[x + 1][y].beam == 1)) {
            return true;
        }
        return false;
    }
    static boolean remove_check(int n){

        for(int i = 1; i<=n+1; i++){
            for(int j = 1; j<=n+1; j++){
                if(!pillar_check(j,i) && matrix[j][i].pillar == 1){
                    return false;
                }
                if(!beam_check(j,i) && matrix[j][i].beam == 1){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        int structure_count = 0;
        matrix = new structure[n+3][n+3];
        for(int i = 0; i<n+3; i++){
            for(int j = 0; j<n+3; j++){
                matrix[j][i] = new structure(j,i);
            }
        }
        for(int i = 0; i<build_frame.length; i++){
            int x = build_frame[i][0] + 1;
            int y = build_frame[i][1] + 1;
            int build = build_frame[i][2];
            int method = build_frame[i][3];
            if(build == 0){
                if(method == 1){
                    if(pillar_check(x,y)){
                        matrix[x][y].pillar = 1;
                        structure_count++;
                    }
                }
                else {
                    matrix[x][y].pillar = 0;
                    if(!remove_check(n)){
                        matrix[x][y].pillar = 1;
                    }
                    else
                        structure_count--;

                }
            }
            else{
                if(method == 1){
                    if(beam_check(x,y)){
                        matrix[x][y].beam = 1;
                        structure_count++;
                    }
                }
                else{
                    matrix[x][y].beam = 0;
                    if(!remove_check(n)){
                        matrix[x][y].beam = 1;
                    }
                    else
                        structure_count--;
                }
            }

        }
        answer = new int[structure_count][3];
        int count = 0;
        for(int i = 1; i<=n+1; i++){
            for(int j = 1; j<=n+1; j++){
                if(matrix[j][i].pillar == 1) {
                    answer[count][0] = j - 1;
                    answer[count][1] = i - 1;
                    answer[count][2] = 0;
                    count++;
                }
                if(matrix[j][i].beam == 1){
                    answer[count][0] = j - 1;
                    answer[count][1] = i - 1;
                    answer[count][2] = 1;
                    count++;
                }
            }
        }
        Arrays.sort(answer, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }
            else
                return Integer.compare(o1[0], o2[0]);
        });
        return answer;
    }
}