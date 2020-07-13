import java.util.Arrays;

class Solution {

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int max = 0;
        int left = 1;
        int right = distance;
        int mid;
        while(left<=right){
            int count = 0;
            int min = distance;
            int rock = 0;
            mid = (left + right)/2;
            for(int i = 0; i<rocks.length; i++){
                if(rocks[i] - rock < mid){
                    //바위 제거
                    count++;
                }
                else {
                    //거리의 최솟값
                    min = Math.min(rocks[i] - rock, min);
                    //다음 바위로 이동
                    rock = rocks[i];
                }
            }
            //도착 지점에서 마지막 바위와의 거리 비교
            if(distance - rock < mid)
                count++;
            else
                min = Math.min(distance - rock, min);

            if(count <= n){
                left = mid + 1;
                max = Math.max(max, min);
            }
            else {
                right = mid - 1;
            }
        }
        return max;
    }
}