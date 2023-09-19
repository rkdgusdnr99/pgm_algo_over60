import java.util.HashMap;
import java.util.Map;

public class number67 {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        Map<Character, Integer> zeroOneMap = new HashMap<>();
        while (s.length() > 1) {
            zeroOneMap.put('0',0);
            zeroOneMap.put('1',0);
            for (int i = 0; i < s.length(); i++) {
                char num = s.charAt(i);
                zeroOneMap.put(num, zeroOneMap.get(num) + 1);
            }
            answer[1] += zeroOneMap.get('0');
            s = Integer.toBinaryString(zeroOneMap.get('1'));
            answer[0]++;
        }
        return answer;
    }
}
