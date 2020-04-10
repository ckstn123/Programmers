import java.util.HashMap;
import java.util.Map;
//호텔 방 배정
class Solution {
    static Map<Long, Long> map = new HashMap<>();
    //배정된 번호 리턴
    static long find(long x){
        //배정 되어있지 않다면
        if(!map.containsKey(x)){
            return x;
        }
        else{//배정 되어있다면
            long y = find(map.get(x));//배정 가능한 번호 받아옴
            map.put(x,y);//방 번호 배정
            return y;
        }
    }
    //배정 가능한 방 번호로 지정
    static void union(long x){
        x= find(x);
        long y = find(x+1);
        map.put(x,y);
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0; i<room_number.length; i++){
            long number = room_number[i];
            number = find(number);
            answer[i] = number;
            union(number);
        }

        return answer;
    }
}