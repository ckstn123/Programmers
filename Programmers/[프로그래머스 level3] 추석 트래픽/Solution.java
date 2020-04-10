//추석 트래픽
class Solution {
    public int solution(String[] lines) {
        int answer = 0;

        long[] start_time = new long[lines.length];
        long[] end_time = new long[lines.length];
        for(int i = 0; i<lines.length; i++){
            String[] temp = lines[i].split(" ");
            String[] times = temp[1].split(":");
            float process_time = Float.parseFloat(temp[2].replaceAll("s", ""));
            end_time[i] = (long) (Long.parseLong(times[0]) * 60*60*1000 + Long.parseLong(times[1]) *60*1000 + Float.parseFloat(times[2])*1000);
            start_time[i] = end_time[i] - (long)(process_time * 1000) + 1;
        }
        for(int i = 0; i<lines.length; i++){
            int count = 0;
            for(int j = 0; j<lines.length; j++){
                if(end_time[i] + 999 < start_time[j] || end_time[i] > end_time[j]){
                    continue;
                }
                count++;
            }
            if(answer < count)
                answer = count;
        }
        return answer;
    }
}