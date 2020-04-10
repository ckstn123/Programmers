import java.util.ArrayList;
//하오니의 탑
class Solution {
    static ArrayList<int[]> arrayList = new ArrayList<>();
    static void recursive(int n, int start, int mid, int end){
        if(n == 1){
            int[] temp = {start, end};
            arrayList.add(temp);
            return;
        }
        else {
            recursive(n-1, start, end, mid);
            int[] temp = {start, end};
            arrayList.add(temp);
            recursive(n-1, mid, start, end);
        }

    }
    public int[][] solution(int n) {
        int[][] answer;
        recursive(n, 1, 2,3);
        answer = new int[arrayList.size()][2];
        for(int i = 0; i<arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}