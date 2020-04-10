
//징검다리 건너기(완전탐색 버전)
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

        //처음부터 마지막에서 k 뺀 만큼 반복
        for(int i = 0; i<=stones.length-k; i++){
            int temp = i; //다음 인덱스를 저장
            int stone = stones[i];
            //해당 인덱스부터 k개 만큼 반복
            for(int j = i; j<i+k; j++){
                if(stones[j] > stone){
                    stone = stones[j];
                    temp = j;
                }
            }
            if(answer > stone){
                answer = stone;
            }
            i = temp;

        }
        return answer;
    }
}