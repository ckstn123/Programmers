import java.util.Stack;

class Solution {
    static int result = 0;
    static Stack<Character> stack = new Stack<>();
    static void dfs(int left, int right, int count, int n){
        if(left > right || left > n || right > n)
            return;
        if(count == 2 * n){
            String temp = "";
            for(char c : stack){
                temp += c;
            }
            System.out.println(temp);
            result++;
            return;
        }
        stack.push(')');
        dfs(left+1, right, count+1, n);
        stack.pop();
        stack.push('(');
        dfs(left, right+1, count+1, n);
        stack.pop();
    }
    public int solution(int n) {

        dfs(0,0,0,n);
        return result;
    }
}