import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static boolean[] user_check;
    static ArrayList<String[]> groups = new ArrayList<>();

    //제재 아이디에 해당하는지 체크
    static boolean check(String a, String b){
        if (a.length() == b.length()) {
            for (int k = 0; k < a.length(); k++) {
                if (a.charAt(k) != '*') {
                    if (a.charAt(k)!=b.charAt(k)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    static void recursive(String[] user_id, String[] banned_id,  int idx_ban, String[] temp){
        //종료부
        if(idx_ban == banned_id.length){//제재 시킨 횟수가 전체 제재 아이디 개수와 같으면
            boolean flag = true;
            String[] t = temp.clone();
            Arrays.sort(t);
            for (String[] group : groups) {
                if(Arrays.equals(group, t)){
                    flag = false;
                    break;
                }
                else {
                    flag = true;
                }
            }
            if(flag){
                groups.add(t);
            }
            return;
        }
        for(int i = 0; i<user_id.length; i++){
            if(!user_check[i]){
                if(check(banned_id[idx_ban], user_id[i])){//제재 아이디에 해당한다면
                    user_check[i] = true;
                    temp[idx_ban] = user_id[i];//제재 시킨 그룹에 넣어준다.
                    //순환부
                    recursive(user_id, banned_id, idx_ban+1, temp);//제재 횟수를 1 증가

                    user_check[i] = false;// 초기화
                }

            }

        }

    }
    public int solution(String[] user_id, String[] banned_id) {
        user_check = new boolean[user_id.length];
        String[] temp = new String[banned_id.length];
        recursive(user_id, banned_id, 0, temp);

        return groups.size();
    }

}