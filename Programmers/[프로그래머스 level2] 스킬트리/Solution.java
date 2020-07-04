import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] index = new int[skill.length()];

        for(int t = 0; t<skill_trees.length; t++){
            boolean flag = false;
            Arrays.fill(index,Integer.MAX_VALUE);
            for(int i = 0; i<skill.length(); i++){
                for(int j = 0; j<skill_trees[t].length(); j++) {
                    if (skill_trees[t].charAt(j) == skill.charAt(i)) {
                        index[i] = j;
                        break;
                    }
                }
            }

            for(int k = 0; k<index.length-1; k++){
                if(index[k] > index[k+1]){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                answer++;
        }
        return answer;
    }
}