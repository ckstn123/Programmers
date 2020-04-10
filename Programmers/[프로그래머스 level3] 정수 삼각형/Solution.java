import java.util.Arrays;

//정수 삼각형(DP 버전)
class Solution {

    public int solution(int[][] triangle) {

        int index = 0; //현재 인덱스
        int size = 0; //전체 원소 개수
        int height = triangle.length;//삼각형의 높이
        for(int i = height; i>0; i--){
            size += i;
        }
        int[] tree = new int[size]; //이차원 배열을 일차원으로 받을 배열
        for(int i = 0; i<height; i++){
            for(int temp : triangle[i]){
                tree[index++] = temp;
            }
        }
        int[] dp = new int[size];
        dp[0] = tree[0];

        index = 0; //현재 인덱스를 0으로 초기화
        for(int i = 1; i<=height; i++){
            for(int j = 0; j<i; j++){
                int left = index + i;//왼쪽 대각선의 인덱스
                int right = index + i + 1;//오른쪽 대각선의 인덱스
                if(left < size){ //배열의 인덱스를 넘지 않도록
                    dp[left] = Math.max(dp[index] + tree[left], dp[left]);
                }
                if(right < size){
                    dp[right] = Math.max(dp[index] + tree[right], dp[right]);
                }
                index++;
            }
        }
        Arrays.sort(dp);//배열 오름차순 정렬

        return dp[size-1]; //가장 큰 원소를 리턴
    }
}