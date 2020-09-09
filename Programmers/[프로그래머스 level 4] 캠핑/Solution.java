import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        Comparator<int[]> comp = (a,b) -> {
            if(a[0] > b[0]){
                return 1;
            }
            else if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else {
                return -1;
            }
        };
        Arrays.sort(data,comp);

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(data[i][0] == data[j][0] || data[i][1] == data[j][1])
                    continue;
                for(int k = i+1; k<j; k++){
                    int x1 = Math.min(data[i][0], data[j][0]);
                    int x2 = Math.max(data[i][0], data[j][0]);
                    int y1 = Math.min(data[i][1], data[j][1]);
                    int y2 = Math.max(data[i][1], data[j][1]);
                    if((x1 < data[k][0] && data[k][0] < x2) && (y1< data[k][1] && data[k][1] < y2)){
                        answer--;
                        break;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}