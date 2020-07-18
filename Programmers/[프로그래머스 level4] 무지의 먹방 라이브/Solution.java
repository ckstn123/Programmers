import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class food{
        int index;
        long time;
        food(int i, long t){
            index = i;
            time = t;
        }
    }
    public int solution(int[] food_times, long k) {
        PriorityQueue<food> pq = new PriorityQueue<>(new Comparator<food>() {
            @Override
            public int compare(food o1, food o2) {
                if (o1.time > o2.time) {
                    return 1;
                } else if (o1.time < o2.time) {
                    return -1;
                } else
                    return 0;
            }
        });
        ArrayList<food> list = new ArrayList<>();
        int size = food_times.length;
        long min = 0;
        long sum = 0;
        for(int i = 0; i<size; i++){
            sum += food_times[i];
            pq.offer(new food(i,food_times[i]));
        }
        if(sum <= k)
            return -1;

        while(true){
            if(pq.peek().time == min){
                pq.poll();
                size--;
            }
            else if(k >= (pq.peek().time - min) * size){
                k -= (pq.peek().time - min) * size;
                min = (pq.peek().time);
                pq.poll();
                size--;
            }
            else
                break;
        }

        k = k%pq.size();

        for(food temp : pq){
            list.add(temp);
        }

        Collections.sort(list, new Comparator<food>() {
            @Override
            public int compare(food o1, food o2) {
                if(o1.index > o2.index){
                    return 1;
                }
                else if(o1.index < o2.index){
                    return -1;
                }
                else
                    return 0;
            }
        });

        return list.get((int)k).index + 1;
    }
}