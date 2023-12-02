import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class number86 {

    public int[] goodSolution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }

    public int[] solution(int[] fees, String[] records){
        int[] answer = {};
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Map<Integer, Date> hashMap = new HashMap<>();
        Map<Integer, Integer> sum = new TreeMap<>();
        try {
            Date lastDate = sdf.parse("23:59");
            long last = lastDate.getTime();
            for (String record: records) {
                String[] parts = record.split(" ");
                int carNum = Integer.parseInt(parts[1]);
                if(parts[2].equals("IN")) {
                    hashMap.put(carNum, sdf.parse(parts[0]));
                }
                else {
                    long time = sdf.parse(parts[0]).getTime() - hashMap.get(carNum).getTime();
                    hashMap.put(carNum, lastDate);
                    time /= 1000;
                    int minute = (int)time / 60;
                    sum.put(carNum, sum.getOrDefault(carNum, 0) + minute);
                }
            }
            for (Map.Entry<Integer, Date> entry : hashMap.entrySet()) {
                long time = last - entry.getValue().getTime();
                time /= 1000;
                int minute = (int)time / 60;
                sum.put(entry.getKey(), sum.getOrDefault(entry.getKey(), 0) + minute);
            }
            answer = new int[sum.size()];

            int index = 0;

            for (int value : sum.values()) {
                answer[index] = calculate(fees,value);
                index++;
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return answer;
    }

    int calculate(int[] fees, int min) {
        int answer = 0;
        min -= fees[0];
        answer += fees[1];
        if (min > 0) {
            answer += (min / fees[2]) * fees[3];
            if (min % fees[2] != 0)
                answer += fees[3];
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[] fees= {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN",
                "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        number86 solution = new number86();
        System.out.println(Arrays.toString(solution.solution(fees, records)));
    }


}