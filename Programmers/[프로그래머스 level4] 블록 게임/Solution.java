class Solution {
    boolean[][] visited;
    static int n; //보드 크기

    // 도달 가능한 곳에 검은 블록 채우기
    void fill(int[][] board){
        for(int x = 0; x<n; x++){
            for(int y = 0; y<n; y++){
                if(board[y][x] != 0 && board[y][x] != -1){
                    break;
                }
                board[y][x] = -1;// 검은 블록 채우기
            }
        }
    }
    boolean check1(int[][] board, int x, int y){
        int num = board[y][x];
        if(x+2 >= n || y+1 >= n){
            return false;
        }
        if(board[y+1][x] == num && board[y+1][x+1] == num && board[y+1][x+2] == num){
            return true;
        }
        return false;
    }

    boolean check2(int[][] board, int x, int y){
        int num = board[y][x];
        if(x+1 >= n || y-2 < 0){
            return false;
        }
        if(board[y-1][x+1] == num && board[y-2][x+1] == num && board[y][x+1] == num){
            return true;
        }
        return false;
    }

    boolean check3(int[][] board, int x, int y){
        int num = board[y][x];
        if(x+1 >= n || y+2 >= n){
            return false;
        }
        if(board[y+1][x] == num && board[y+2][x] == num && board[y+2][x+1] == num){
            return true;
        }
        return false;
    }

    boolean check4(int[][] board, int x, int y){
        int num = board[y][x];
        if(x+2 >= n || y-1 < 0){
            return false;
        }
        if(board[y][x+1] == num && board[y][x+2] == num && board[y-1][x+2] == num){
            return true;
        }
        return false;
    }

    boolean check5(int[][] board, int x, int y){
        int num = board[y][x];
        if(x+2 >= n || y-1 < 0){
            return false;
        }
        if(board[y][x+1] == num && board[y][x+2] == num && board[y-1][x+1] == num){
            return true;
        }
        return false;
    }

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        int count = 1;
        visited = new boolean[n][n];
        fill(board);
        //더 이상 직사각형이 만들어지지 않을 때까지 반복
        while(count != 0) {
            count = 0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    //빈칸도 아니고 검은 블록도 아니면
                    if(board[y][x] != 0 && board[y][x] != -1){
                        if (check1(board, x, y)) {
                            //직사각형으로 채워져 있으면
                            if (board[y][x + 1] == -1 && board[y][x + 2] == -1) {
                                board[y][x] = 0;
                                board[y + 1][x] = 0;
                                board[y + 1][x + 1] = 0;
                                board[y + 1][x + 2] = 0;
                                count++;
                                fill(board);
                            }
                        } else if (check2(board, x, y)) {
                            if (board[y - 1][x] == -1 && board[y - 2][x] == -1) {
                                board[y][x] = 0;
                                board[y - 1][x + 1] = 0;
                                board[y - 2][x + 1] = 0;
                                board[y][x + 1] = 0;
                                count++;
                                fill(board);
                            }
                        } else if (check3(board, x, y)) {
                            if (board[y][x + 1] == -1 && board[y + 1][x + 1] == -1) {
                                board[y][x] = 0;
                                board[y + 1][x] = 0;
                                board[y + 2][x] = 0;
                                board[y+2][x + 1] = 0;
                                count++;
                                fill(board);
                            }
                        } else if (check4(board, x, y)) {
                            if (board[y - 1][x] == -1 && board[y - 1][x + 1] == -1) {
                                board[y][x] = 0;
                                board[y][x + 1] = 0;
                                board[y][x + 2] = 0;
                                board[y - 1][x + 2] = 0;
                                count++;
                                fill(board);
                            }
                        } else if (check5(board, x, y)) {
                            if (board[y - 1][x] == -1 && board[y - 1][x + 2] == -1) {
                                board[y][x] = 0;
                                board[y][x + 1] = 0;
                                board[y][x + 2] = 0;
                                board[y - 1][x + 1] = 0;
                                count++;
                                fill(board);
                            }
                        }
                    }
                }
            }
            answer += count;
        }
        return answer;
    }
    
}
