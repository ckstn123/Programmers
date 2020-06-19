import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class truck{
        int weight, time;
        truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> finish = new ArrayList<>();
        Queue<truck> running = new LinkedList<>();
        int index = 0;

        while(finish.size() < truck_weights.length){
            int total_weight = 0;
            if(!running.isEmpty() && running.peek().time + 1 == bridge_length){
                finish.add(running.poll().weight);
            }
            for(truck temp : running){
                temp.time++;
                total_weight += temp.weight;
            }
            if(index < truck_weights.length && total_weight + truck_weights[index] <= weight){
                running.offer(new truck(truck_weights[index++], 0));
            }

            answer++;
        }
        return answer;
    }
}