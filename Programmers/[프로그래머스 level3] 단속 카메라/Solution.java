import java.util.Arrays;
import java.util.Comparator;

//단속 카메라
class Solution {

    public int solution(int[][] routes) {
        int answer = 1;
        int temp = 0;
        Comparator<int[]> costComparator = (a, b) -> {
            return a[0] - b[0];
        };

        Arrays.sort(routes, costComparator);
        temp = routes[0][1];
        for(int i = 1; i<routes.length; i++){

            if(temp > routes[i][1]){
                temp = routes[i][1];
            }
            if(temp < routes[i][0]){
                answer++;
                temp = routes[i][1];
            }
        }

        return answer;
    }
}