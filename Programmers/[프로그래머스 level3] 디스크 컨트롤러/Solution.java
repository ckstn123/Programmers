import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//디스크 컨트롤러
class Solution {
    static class job{
        int req, proc;
        job(int r, int p){
            this.req = r;
            this.proc = p;
        }
    }

    static ArrayList<job> wait_list = new ArrayList<>();
    Comparator<job> com = new Comparator<job>() {
        @Override
        public int compare(job o1, job o2) {
            return o1.proc - o2.proc;
        }
    };
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = 0;

        for(int i = 0; i<jobs.length; i++){
            wait_list.add(new job(jobs[i][0],jobs[i][1]));
        }

        Collections.sort(wait_list,com);
        while(!wait_list.isEmpty()){
            int flag = 0;
            for(int i = 0; i<wait_list.size(); i++){
                if(n >= wait_list.get(i).req){
                    n += wait_list.get(i).proc;
                    answer += n - wait_list.get(i).req;
                    wait_list.remove(i);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                n++;
        }
        answer /= jobs.length;
        return answer;
    }
}