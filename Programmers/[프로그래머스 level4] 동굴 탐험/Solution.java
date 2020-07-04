import java.util.*;

class Solution {
    static ArrayList<Integer>[] link_list;
    static ArrayList<Integer>[] room_order;
    static boolean[] visited;

    static class Room{
        int num, idx;
        Room(int n, int i){
            num = n;
            idx = i;
        }
    }
    static boolean isCycle(){
        boolean[] check = new boolean[visited.length];
        Stack<Room> stack = new Stack<Room>();
        stack.add(new Room(0, 0));
        visited[0] = true;

        while (!stack.isEmpty()) {
            Room temp = stack.pop();
            if (temp.idx == room_order[temp.num].size()) {
                check[temp.num] = true;
                continue;
            }
            stack.add(new Room(temp.num, temp.idx + 1));

            int next = room_order[temp.num].get(temp.idx);
            if (!visited[next]) {
                stack.add(new Room(next, 0));
                visited[next] = true;
            } else if (!check[next]) {
                return false;
            }

        }
        return true;
    }
    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i = 0; i<link_list[temp].size(); i++){
                int next = link_list[temp].get(i);

                if(visited[next])
                    continue;
                room_order[temp].add(next);
                queue.add(next);
                visited[next] = true;
            }
        }
    }
    public boolean solution(int n, int[][] path, int[][] order) {

        link_list = new ArrayList[n];
        room_order = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            link_list[i] = new ArrayList<Integer>();
            room_order[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<path.length; i++){
            link_list[path[i][0]].add(path[i][1]);
            link_list[path[i][1]].add(path[i][0]);
        }

        bfs(0);

        for(int i = 0; i<order.length; i++){
            room_order[order[i][0]].add(order[i][1]);
        }

        visited = new boolean[n];
        return isCycle();
    }

}