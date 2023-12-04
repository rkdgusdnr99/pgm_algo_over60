import java.util.*;

public class number87 {
    public int solution(String word) {
        Map<String, Integer> hashMap = new HashMap<>();
        char[] XAEIOU = {'X', 'A', 'E', 'I', 'O', 'U'};
        recursion(hashMap, XAEIOU, "");
        return hashMap.get(word);
    }

    void recursion(Map<String, Integer> hashMap, char[] XAEIOU, String key) {
        for (char alphabet: XAEIOU) {
            if (alphabet == 'X')
                hashMap.put(key,hashMap.size());
            else if (key.length() == 4)
                hashMap.put(key + alphabet,hashMap.size());
            else
                recursion(hashMap, XAEIOU, key + alphabet);
        }
    }

    public int legendSolution(String word) { // 미친 풀이 경우의 수를 이용했다.
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }

    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    public int dfsSolution(String word) { // List를 사용해 더 간단하게 풀이한 모습
        dfs("", 0);
        return list.indexOf(word);
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시

        number87 solution = new number87();
        System.out.println(solution.solution("AAAAE"));
        System.out.println(solution.solution("AAAE"));
        System.out.println(solution.solution("I"));
        System.out.println(solution.solution("EIO"));

    }
}
