import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//여행경로
class Solution {

    static List<String> array = new ArrayList<>();//가능한 모든 답을 담을 리스트
    static String[] String_array;
    static void recursive(String[][] tickets, int index,int[] visited, String end){

        String_array[index] = end; //방문한 도착지를 배열에 넣는다.
        if(index == tickets.length){
            String temp = "";
            for(String str : String_array){//배열의 모든 문자열을 하나로 합쳐준다
                temp += str + ",";
            }
            array.add(temp); //가능한 답을 넣어준다.
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(tickets[i][0].equals(end) && visited[i] == 0){
                visited[i] = 1;//방문했다고 표시
                recursive(tickets,index+1, visited, tickets[i][1]);
                visited[i] = 0;//초기화

            }
        }
        String_array[index] = ""; //초기화
    }
    public String[] solution(String[][] tickets) {
        String[] answer;

        int[] visited = new int[tickets.length];
        for (int i = 0; i<tickets.length; i++){
            if (tickets[i][0].equals("ICN")){ //ICN으로 시작하도록 조건 설정
                String_array = new String[tickets.length + 1];
                visited[i] = 1;
                String end = tickets[i][1];
                String_array[0] = tickets[i][0];
                recursive(tickets,1,visited,end);
                visited[i] = 0;
            }
        }
        Collections.sort(array);
        answer = array.get(0).split(","); //추가한 ,를 구분하면서 배열 생성

        return answer;
    }
}