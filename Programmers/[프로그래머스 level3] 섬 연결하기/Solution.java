import java.util.Arrays;
import java.util.Comparator;

//섬 연결하기
class Solution {
    static int[] parent;

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[y] = x;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean checkParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return true;
        }
        return false;
    }


    public int solution(int n, int[][] costs) {
        int sum = 0;
        Comparator<int[]> costComparator = (a, b) -> {
            return a[2] - b[2];
        };
        Arrays.sort(costs, costComparator);

        parent = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        for(int i = 0; i<costs.length; i++){
            if(!checkParent(costs[i][0] ,costs[i][1])){
                sum += costs[i][2];
                union(costs[i][0],costs[i][1]);
            }
        }

        return sum;
    }
}