import java.util.Arrays;

//야근 지수
class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        int[] add_works = new int[works.length+1]; //가장 작은 값 0을 넣어줄 배열
        System.arraycopy(works,0,add_works,0,works.length);
        Arrays.sort(add_works);
        int count = 1; //진행되는 작업들을 세아림
        for(int i = add_works.length-1; i>0; i--){
            int diff = add_works[i] - add_works[i-1];

            if(diff * count <= n){
                for(int j = 0; j<count; j++){
                    add_works[i+j] -= diff;
                }
                n -= diff * count;
            }
            else {
                int temp = n/count; //진행된 작업에 대한 작업량 처리량
                int rest = n%count;
                for(int k = 0; k<count; k++){
                    add_works[add_works.length-1-k] -= temp;
                }
                for(int k = 0; k<rest; k++){
                    add_works[add_works.length-1-k] -= 1;
                }

                break;
            }
            count++;
        }
        for (int work : add_works) {
            answer += work * work;
        }
        return answer;
    }
}