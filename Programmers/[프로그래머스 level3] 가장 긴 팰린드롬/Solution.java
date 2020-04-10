//가장 긴 팰린드롬
public class Solution {
    static int max = 0;

    public static boolean check(String temp, int front, int back){
        if((back-front)%2 == 0){ //자릿수가 홀수인 경우
            for(int i = 0; i<(back-front)/2; i++){
                //앞뒤로 비교해간다.
                if(temp.charAt(front+i) != temp.charAt(back-i)){
                    return false;
                }
            }
            return true;
        }
        else { //자릿수가 짝수인 경우
            for(int i = 0; i<(back-front)/2 + 1; i++){
                if(temp.charAt(front+i) != temp.charAt(back-i)){
                    return false;
                }
            }
            return true;
        }

    }

    public int solution(String s)
    {
        int len = s.length();
        //문자열 전체가 팰린드롬인 경우
        if(check(s,0,len-1))
            return len;

        for(int i = len-1; i>0; i--){//부분문자열 길이를 줄여간다.
            for(int j = 0; j<len-i+1; j++){//기준 인덱스를 늘여간다.
                int front = j;//기준 인덱스부터 시작
                int back = i+j-1;// 부분문자열 마지막 인덱스

                if(i <= max){ //부분문자열 길이가 max보다 작거나 같으면
                    return max;
                }
                if(check(s,front,back)){
                    if(max < i){
                        max = i;
                    }
                }
            }

        }
        return max;
    }
}
