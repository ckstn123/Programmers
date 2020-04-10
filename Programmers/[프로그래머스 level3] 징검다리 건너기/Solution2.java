import java.util.Arrays;
//징검다리 건너기 (이분탐색 버전)
class Solution2 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int[] array = stones.clone();
        Arrays.sort(array);
        int left = array[0];
        int right = array[array.length-1];

        while(left <= right){
            int mid = (left+right)/2;
            int count = 0;//연속으로 0인 돌 개수
            int max = 0;//연속으로 0인 최대 돌 개수

            for(int temp : stones){
                if(temp < mid){
                    count++;
                    max = Math.max(max, count);
                }
                else{
                    count = 0;
                }
            }
            if(max < k){ //k와 같으면 못 건너므로 작을 경우에 답이 나옴
                left = mid + 1;
                if(answer < mid){
                    answer = mid;
                }
            }
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
}