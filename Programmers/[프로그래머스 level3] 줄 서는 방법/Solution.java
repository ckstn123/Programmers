import java.util.ArrayList;

//줄 서는 방법
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> people = new ArrayList<>();//대기하고 있는 사람들

        long factorial = 1;
        int index = 0;
        for(int i = 1; i<= n; i++){
            factorial *= i; //숫자 하나당 생길수 있는 방법의 수
            people.add(i);
        }
        while(n > 0){
            factorial /= n;
            if (k % factorial == 0) { //나머지가 0이면
                answer[index++] = people.remove((int) (k/factorial) -1); //몫의 1을 뺀 순서의 사람을 뽑는다
                for(int i = people.size()-1; i>=0; i--){ //뽑은 뒤엔 남은 사람의 역순으로 다 뽑는다.
                    answer[index++] = people.remove(i);
                }
                break;//다 뽑았으므로 반복문을 끝낸다.
            }
            else{
                answer[index++] = people.remove((int) (k/factorial)); //몫에 해당하는 순서의 사람을 뽑는다.
            }
            k = k % factorial; //남은 자리의 순서를 최신화
            n--;

        }
        return answer;
    }
}