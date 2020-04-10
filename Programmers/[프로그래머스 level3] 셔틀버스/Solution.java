import java.util.ArrayList;
import java.util.Collections;

//셔틀버스(너무 복잡하게 생각하지 않기)
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int start = 540; //9시
        int index = 0;
        int result = 0;
        ArrayList<Integer> pq = new ArrayList<>();
        for(int i = 0; i<timetable.length; i++){
            String[] temp = timetable[i].split(":");
            int time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            pq.add(time);
        }
        Collections.sort(pq);//오름차순으로 정렬
        for(int i = 0; i<n; i++){
            int count = 0;//한 셔틀 버스에 몇명 탔는지

            for(int j = 0; j<m; j++){
                if(index < timetable.length){
                    if(pq.get(index) <= start){//각 버스 도착 시간보다 빠르거나 같은 시간에 도착했다면
                        count++;//버스 탑승
                        index++;
                    }
                }

            }
            if(i == n-1){//마지막 버스인 겅유
                if(count == m){//마지막 자리까지 탑승했다면
                    result = pq.get(index-1) - 1;//마지막 탑승객보다 1분 빨리 도착
                }
                else{
                    result = start;//버스가 꽉 차지 않았으면 버스 도착 시간에 도착
                }
            }
            start += t;
        }
        int hour = result/60;
        int min = result%60;
        if(hour < 10){
            answer += '0' + String.valueOf(hour) + ':';
        }
        else {
            answer += String.valueOf(hour) + ':';
        }
        if(min < 10){
            answer += '0' + String.valueOf(min);
        }
        else {
            answer += String.valueOf(min);
        }
        return answer;
    }
}