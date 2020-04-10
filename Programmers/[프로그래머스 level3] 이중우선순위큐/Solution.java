import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//이중우선순위큐
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> queue = new LinkedList<>();

        for(String temp : operations){
            String[] operation = temp.split(" ");
            if(operation[0].equals("I")){
                queue.add(Integer.parseInt(operation[1]));
            }
            else{
                if(!queue.isEmpty()){
                    if(operation[1].equals("1")){
                        Collections.sort(queue);
                        queue.remove(queue.size()-1);
                    }
                    else{
                        Collections.sort(queue);
                        queue.remove(0);
                    }
                }

            }
        }
        Collections.sort(queue);
        if(!queue.isEmpty()){
            answer[0] = queue.get(queue.size()-1);
            answer[1] = queue.get(0);
        }

        return answer;
    }
}