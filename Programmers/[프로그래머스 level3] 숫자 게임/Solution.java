import java.util.ArrayList;
import java.util.Arrays;

//숫자 게임
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int size = A.length;
        boolean flag = false; //매칭이 되었는지 확인할 변수
        Arrays.sort(A);//오름차순으로 정렬
        Arrays.sort(B);
        ArrayList<Integer> A_list = new ArrayList<>();
        ArrayList<Integer> B_list = new ArrayList<>();
        for(int i = 0; i<size; i++){
            A_list.add(A[i]);
            B_list.add(B[i]);
        }
        for(int i = B_list.size()-1; i>=0;i--){ //B의 인덱스
            flag = false;
            for(int j = A_list.size()-1; j>=0; j--){//A의 인덱스
                if(B_list.get(i) > A_list.get(j)){//B의 원소가 더 클 때까지 확인
                    answer++;//찾았으면 승점 획득
                    flag = true;//매칭되었다고 표시
                    B_list.remove(i);//매칭된 원소 삭제
                    A_list.remove(j);//매칭된 원소 삭제
                    i--;//B의 원소가 삭제되었으므로 인덱스도 하나 줄여준다.
                }
            }
            if(!flag){//매칭이 되지 않았다는건 더 이상 B보다 작은 A원소가 없다는 뜻이므로 승점을 얻지 못한다.
                return answer;//이때까지 얻은 승점 리턴
            }
        }
        return answer;
    }
}