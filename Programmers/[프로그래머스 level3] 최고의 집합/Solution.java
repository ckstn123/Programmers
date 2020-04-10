//최고의 집합(쉬움)
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int rest = s%n;
        if(n > s){
            int[] result = {-1};
            return result;
        }
        for(int i = 0; i<n; i++){
            answer[i] = s/n;
        }
        for(int i = n-1; i>n-1-rest; i--){
            answer[i]++;
        }

        return answer;
    }
}