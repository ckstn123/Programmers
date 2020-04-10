//기지국 설치
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i = 0; i<stations.length; i++){
            if(i==0){
                int temp = stations[i] - w - 1;
                if(temp > 0){
                    answer += temp/(2*w+1);
                    if(temp%(2*w+1) > 0)
                        answer++;
                }

            }
            else{
                int temp = stations[i] - stations[i-1]- 2*w -1;
                if(temp > 0){
                    answer += temp/(2*w+1);
                    if(temp%(2*w+1) > 0)
                        answer++;
                }

            }

        }
        int temp = n -stations[stations.length-1] - w;
        if(temp > 0){
            answer += temp/(2*w+1);
            if(temp%(2*w+1) > 0)
                answer++;
        }
        return answer;
    }
}