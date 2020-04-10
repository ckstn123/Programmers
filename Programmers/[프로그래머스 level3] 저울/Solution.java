import java.util.Arrays;

//저울
class Solution {
    public int solution(int[] weight) {

        int num = 1;//기존 더 하는 무게에 1만큼 추가
        Arrays.sort(weight);

        for(int i = 0; i<weight.length; i++){

            if(num >= weight[i]){//만들 수 있는 무게
                num += weight[i];
            }
            else{
                return num;
            }
        }
        return num;
    }
}