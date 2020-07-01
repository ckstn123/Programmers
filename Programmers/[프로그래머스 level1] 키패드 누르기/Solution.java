//키패드 누르기
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left_x, left_y;
        int right_x, right_y;
        left_x = 0;
        left_y = 3;
        right_x = 2;
        right_y = 3;

        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                left_x = (numbers[i]-1)%3;
                left_y = (numbers[i]-1)/3;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right_x = (numbers[i]-1)%3;
                right_y = (numbers[i]-1)/3;
            }
            else {
                if(numbers[i] == 0){
                    if(Math.abs(1-left_x) + 3 - left_y > Math.abs(1-right_x) + 3 - right_y){
                        right_x = 1;
                        right_y = 3;
                        answer += "R";
                    }
                    else if(Math.abs(1-left_x) + 3 - left_y < Math.abs(1-right_x) + 3 - right_y){
                        left_x = 1;
                        left_y = 3;
                        answer += "L";
                    }
                    else {
                        if(hand.equals("right")){
                            right_x = 1;
                            right_y = 3;
                            answer += "R";
                        }
                        else {
                            left_x = 1;
                            left_y = 3;
                            answer += "L";
                        }
                    }
                }
                else {
                    if(Math.abs((numbers[i]-1)%3-left_x) + Math.abs((numbers[i]-1)/3 - left_y) > Math.abs((numbers[i]-1)%3-right_x) + Math.abs((numbers[i]-1)/3 - right_y)){
                        right_x = (numbers[i]-1)%3;
                        right_y = (numbers[i]-1)/3;
                        answer += "R";
                    }
                    else if(Math.abs((numbers[i]-1)%3-left_x) + Math.abs((numbers[i]-1)/3 - left_y) < Math.abs((numbers[i]-1)%3-right_x) + Math.abs((numbers[i]-1)/3 - right_y)){
                        left_x = (numbers[i]-1)%3;
                        left_y = (numbers[i]-1)/3;
                        answer += "L";
                    }
                    else {
                        if(hand.equals("right")){
                            right_x = (numbers[i]-1)%3;
                            right_y = (numbers[i]-1)/3;
                            answer += "R";
                        }
                        else {
                            left_x = (numbers[i]-1)%3;
                            left_y = (numbers[i]-1)/3;
                            answer += "L";
                        }
                    }
                }
            }
        }
        return answer;
    }
}