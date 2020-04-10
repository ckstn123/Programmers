import java.util.Stack;

//네트워크
class Solution {
    static Stack<Integer> stack = new Stack<Integer>();
    static boolean[] visited;

    static void dfs(int n, int[][] computers, int index){
        visited[index] = true;//해당 컴퓨터에 접근했으므로 방문했다고 표시
        stack.add(index); //해당 컴퓨터를 스택에 넣음
        while(!stack.isEmpty()){
            int temp = stack.pop(); //스택에 있는 컴퓨터 번호를 팝해줌
            for(int i = 0; i<n; i++){
                //같은 번호는 제외하고 i번 컴퓨터와 연결되어 있고 방문하지 않았다면
                if(i != temp && computers[temp][i] == 1 && !visited[i]){
                    visited[i] = true;//방문했다고 표시
                    stack.add(i);//스택에 넣어줌
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i<n; i++){
            if(!visited[i]){//여기가 중요 방문안한 곳이 있으면
                answer++;//다른 네트워크이므로 개수를 올려줌
                dfs(n, computers, i);//같은 네트워크들을 접근함
            }
        }
        return answer;
    }
}