import java.util.Arrays;

//입국심사
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long sum = 0;
        Arrays.sort(times); //빠른 순으로 정렬

        long left = 0;
        long right = (long)times[times.length-1]*n; //넉넉하게 잡는다
        while(left<=right){
            sum = 0;
            long mid = (left + right)/2;
            for(int i = 0; i<times.length; i++){
                sum += mid/times[i]; //심사관마다의 심사한 인원
            }
            if(n>sum){ //아직 도달하지 않음
                left = mid + 1;
            }
            else{//도달한 경우
                if(mid<=answer){ //최소값을 넣는다.
                    answer = mid;
                }
                right = mid - 1;
            }
        }
        return answer;
    }
}