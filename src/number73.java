import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class number73 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : tangerine) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            k -= entry.getValue();
            answer++;
            if (k < 1)
                return answer;
        }
        return answer;
    }
}
