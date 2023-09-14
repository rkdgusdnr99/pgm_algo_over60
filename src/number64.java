import java.util.HashMap;
import java.util.Map;

public class number64 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 누가 몇번 신고 당했는지
        Map<String, Integer> trollMap = new HashMap<>();
        for (String id : id_list) {
            trollMap.put(id, 0);
        }
        // 누가 누굴 신고했는지
        Map<String, String> userMap = new HashMap<>();
        for (String id : id_list) {
            userMap.put(id, "  ");
        }

        // 위 두개의 Map을 완성
        for (String r: report) {
            String[] parts = r.split(" ");
            String troll = parts[1];
            String user = parts[0];

            if (!userMap.get(user).contains(" " + troll + " ")){
                trollMap.put(troll, trollMap.get(troll) + 1);
                userMap.put(user, userMap.get(user) + troll + "  ");
            }
        }

        for (String troll : id_list) {
            int value = trollMap.get(troll);

            if (value >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (userMap.get(id_list[i]).contains(" " + troll + " "))
                        answer[i]++;
                }
            }
        }
        return answer;
    }
}
