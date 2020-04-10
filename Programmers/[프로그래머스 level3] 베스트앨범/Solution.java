import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//베스트앨범
class Solution {
    static class song{
        String genres;
        int plays,id;
        song(String g, int p){
            this.genres = g;
            this.plays = p;
        }
        song(String g, int p, int id){
            this.genres = g;
            this.plays = p;
            this.id = id;
        }
    }


    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int size = genres.length;
        ArrayList<song> total = new ArrayList<>();
        ArrayList<song> list = new ArrayList<>();
        for(int i = 0; i<size; i++){
            boolean flag = false;

            for(song temp : list){
                if(temp.genres.equals(genres[i])){
                    temp.plays += plays[i];
                    flag = true;
                }

            }
            if(!flag){
                list.add(new song(genres[i], plays[i]));
            }
        }
        System.out.println(list.size());
        Comparator<song> comp = new Comparator<song>() {
            @Override
            public int compare(song o1, song o2) {
                return o2.plays - o1.plays;
            }
        };
        Collections.sort(list, comp);
        for(int i = 0; i<list.size(); i++){

            ArrayList<song> temp = new ArrayList<>();
            for(int j = 0; j<size; j++){
                if(list.get(i).genres.equals(genres[j])){
                    temp.add(new song(genres[j], plays[j], j));
                }
            }
            Collections.sort(temp, comp);
            if(temp.size() == 1){
                total.add(temp.get(0));
            }
            else if(temp.size() > 1){
                total.add(temp.get(0));
                total.add(temp.get(1));
            }
        }
        Comparator<song> total_comp = new Comparator<song>() {
            @Override
            public int compare(song o1, song o2) {
                if(o1.genres.equals(o2.genres)){
                    if(o1.plays != o2.plays){
                        return o2.plays - o1.plays;
                    }
                    else
                        return o1.id - o2.id;
                }
                return 0;
            }
        };
        Collections.sort(total,total_comp);
        answer = new int[total.size()];
        for(int i = 0; i<total.size(); i++){
            answer[i] = total.get(i).id;
        }
        return answer;
    }
}