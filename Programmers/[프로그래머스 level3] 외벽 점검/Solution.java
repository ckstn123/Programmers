import java.util.Arrays;

//외벽 점검
class Solution {
    static boolean[] weak_visited; //취약 지점을 방문했는지
    static boolean[] dist_visited; //친구가 점검갔는지
    static int min = Integer.MAX_VALUE;

    static void recursive(int[] weak, int[] dist, int start, int count){
        //종료부
        if(min <= count){
            return;
        }
        //해결부
        if(start == weak.length){
            if(min > count){
                min = count;
            }
            return;
        }
        boolean[] temp = weak_visited.clone();

        for(int i = dist.length-1; i>=0; i--){
            if(dist_visited[i])
                continue;
            int num = 0; //취약 지점을 얼마나 갔는지 저장해주는 변수
            dist_visited[i] = true; //친구 출발했다고 표시
            weak_visited = temp.clone();//초기화
            for(int j = start; j<weak.length; j++){
                //취약 지점이 기준점과의 거리가 친구가 갈 수 있는 거리보다 작거나 같고 아직 방문하지 않았다면
                if(weak[j] - weak[start] <= dist[i] && !weak_visited[j]){
                    weak_visited[j] = true;//방문했다고 표시
                    num++;//취약 지점 방문 횟수 1증가
                }
                else{
                    break;
                }
            }
            if(num > 0){
                //분할부
                recursive(weak,dist,start+num, count+1);

            }
            //초기화
            dist_visited[i] = false;
        }
    }
    public int solution(int n, int[] weak, int[] dist) {

        int[] new_weak = new int[weak.length];

        dist_visited = new boolean[dist.length];
        Arrays.sort(dist);// 오름차순으로 정렬
        if(dist[dist.length-1] >= n){//친구의 가장 긴 거리가 전체 길이보다 크거나 같으면
            return 1;//친구 한명만 가면 되므로 1 리턴
        }
        for(int i = 0; i<weak.length; i++){
            weak_visited = new boolean[weak.length];
            for(int j = 0; j<weak.length; j++){
                //매번 기준을 달리하여 그 기준 보다 작은 지점은 전체 길이만큼 더해준다
                if(weak[i] <= weak[(i+j)%weak.length])
                    new_weak[j] = weak[(i+j)%weak.length];
                else
                    new_weak[j] = weak[(i+j)%weak.length] + n;
            }
            recursive(new_weak,dist,0,0);
        }
        if(min <= dist.length)
            return min;
        else
            return -1;
    }
}