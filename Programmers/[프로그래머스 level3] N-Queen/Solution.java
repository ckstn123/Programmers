//N-Queen
class Solution {
    static int[][] matrix;
    static int result = 0;
    static boolean check(int x, int y){
        int n = matrix.length;
        //가로, 세로 확인
        for(int i = 0; i<n; i++){
            if(matrix[x][i] == 1){
                return false;
            }
            if(matrix[i][y] == 1){
                return false;
            }

        }
        //대각선 확인
        for (int i = 1; i<n; i++){
            if(x + i < n && y+i < n){
                if(matrix[x+i][y+i] == 1){
                    return false;
                }
            }
            if(x + i < n && y-i >= 0){
                if(matrix[x+i][y-i] == 1){
                    return false;
                }
            }
            if(x-i >= 0 && y+i < n){
                if(matrix[x-i][y+i] == 1){
                    return false;
                }
            }
            if(x-i >= 0 && y-i >= 0){
                if(matrix[x-i][y-i] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    static void recursive(int count, int n){
        if(count == n){
            result++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(check(count,i)){
                matrix[count][i] = 1;
                recursive(count + 1, n);
                matrix[count][i] = 0;
            }
        }
    }
    public int solution(int n) {

        matrix = new int[n][n];
        recursive(0,n);
        return result;
    }
}