import java.util.*;

//보석 쇼핑
class Solution {
    static class range{
        int left,right,len;
        range(int l, int r, int len){
            left = l;
            right = r;
            this.len = len;
        }
    }
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int left = 0, right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        ArrayList<range> list = new ArrayList<>();
        for(int i = 0; i<gems.length; i++){
            if(map.containsKey(gems[i])){
                int count = map.get(gems[i]);
                map.put(gems[i],count + 1);
            }
            else
                map.put(gems[i],1);
        }
        //전체 보석 종류
        int num = map.size();
        map.clear();

        while(right != gems.length && left != gems.length){
            if(sum >= num){
                if(map.containsKey(gems[left])){
                    int count = map.get(gems[left]);
                    if(count == 1) {
                        map.remove(gems[left]);
                        sum--;
                    }
                    else {
                        map.put(gems[left],count - 1);
                    }
                }
                left++;
            }

            else {
                if(!map.containsKey(gems[right])){
                    sum++;
                    map.put(gems[right], 1);
                }
                else {
                    int count = map.get(gems[right]);
                    map.put(gems[right],count + 1);
                }
                right++;
            }
            if(sum == num){
                int len = right - left - 1;
                if(min > len){
                    min = len;
                }
                list.add(new range(left, right-1, len));
            }
        }
        for(range temp : list){
            if(temp.len == min){
                answer[0] = temp.left + 1;
                answer[1] = temp.right + 1;
                break;
            }
        }
        return answer;
    }

}
