//단어 변환
class Solution {
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    //static Queue<String> queue = new LinkedList<>();
    static boolean check(String str, String target){
        int count = 0;
        for(int i = 0; i<target.length(); i++){
            if(str.charAt(i) == target.charAt(i)){
                count++;
            }
        }
        return count == str.length() - 1;
    }

    static void bfs(String temp, String target, String[] words, int count){

        if(temp.equals(target)){
            if(min > count){
                min = count;
            }
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(check(temp, words[i]) && visited[i] == 0){
                visited[i] = 1;
                bfs(words[i], target, words, count+1);
                visited[i] = 0;

            }
        }

    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];
        boolean flag = false;

        for(String word : words){
            if (word.equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag){
            return 0;
        }
        bfs(begin,target,words,0);
        answer = min;
        if(answer > words.length){
            return 0;
        }
        return answer;
    }
}