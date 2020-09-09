class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int left = 0, right = 0, sum1 = 0, sum2 = 0;

        for(int i = 0; i<cookie.length-1; i++){
            left = i;
            sum1 = cookie[left];
            right = i+1;
            sum2 = cookie[right];
            while (true){
                if(sum1 == sum2 && answer < sum1){
                    answer = sum1;
                }
                else if(sum1 >= sum2){
                    right++;
                    if(right >= cookie.length)
                        break;
                    sum2 += cookie[right];
                }
                else if(sum1 < sum2){
                    left--;
                    if(left < 0)
                        break;
                    sum1 += cookie[left];
                }
                else {
                    break;
                }
            }
        }

        return answer;
    }
}