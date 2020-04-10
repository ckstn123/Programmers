//예산
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = 0;
        for (int budget : budgets) {
            if (budget > right) {
                right = budget;
            }
        }
        int mid = 0;
        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;
            for(int i = 0; i<budgets.length; i++){
                sum += Math.min(mid, budgets[i]);
            }
            if(sum <= M){
                left = mid + 1;
                if(answer < mid)
                    answer = mid;
            }
            else{
                right = mid - 1;
            }

        }
        return answer;
    }
}