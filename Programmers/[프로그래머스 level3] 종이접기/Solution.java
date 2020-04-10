//종이접기
class Solution {
    static void recursive(int[] array, int index, int left, int right){
        if(index % 2 == 0)
            return;
        array[(index+left)/2] = 0;
        recursive(array, (index+left)/2, left, index);
        array[(index+right)/2] = 1;
        recursive(array, (index+right)/2, index, right);
    }
    public int[] solution(int n) {
        int[] answer;
        int size = 1;
        for(int i = 1; i<n; i++){
            size = size * 2 + 1;
        }
        answer = new int[size];
        answer[size/2] = 0;
        recursive(answer, size/2, 0, size);
        return answer;
    }
}