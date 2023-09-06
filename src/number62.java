import java.util.HashMap;
import java.util.Map;

public class number62 {
    public String[] mySolution(String[] players, String[] callings) {
        Map<String, Integer> keyToValueMap = new HashMap<>();
        Map<Integer, String> valueToKeyMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            keyToValueMap.put(players[i], i);
            valueToKeyMap.put(i, players[i]);
        }
        for (String calling: callings) {
            int i = keyToValueMap.get(calling);
            String player1 = valueToKeyMap.get(i);
            String player2 = valueToKeyMap.get(i-1);
            keyToValueMap.put(player1, i - 1);
            keyToValueMap.put(player2, i);
            valueToKeyMap.put(i-1, player1);
            valueToKeyMap.put(i,player2);
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            answer[i] = valueToKeyMap.get(i);
        }
        return answer;
    }

    public String[] goodSolution(String[] players, String[] callings) { // 2배 정도 더 빠름
        int n = players.length;
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = indexMap.get(calling);
            if (idx > 0) {
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;

                indexMap.put(players[idx - 1], idx - 1);
                indexMap.put(players[idx], idx);
            }
        }

        return players;
    }
}
