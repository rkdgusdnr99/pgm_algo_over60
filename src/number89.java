import java.util.*;
public class number89 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> big = new HashMap<>();
        Set<Integer> small = new HashSet<>();
        for (int t : topping) {
            big.put(t, big.getOrDefault(t, 0) + 1);
        }
        for (int t : topping) {
            if (big.containsKey(t)) {
                int num = big.get(t);
                if (num == 1)
                    big.remove(t);
                else
                    big.put(t,num-1);
            }
            small.add(t);
            if (small.size() == big.size())
                answer++;
        }
        return answer;
    }

    public int otherSolution(int[] topping) { // set의 성질을 배열로 직접 구현
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        for(var i : topping) right[i]++;
        for(var i : right) rs += i > 0 ? 1 : 0;
        for(var i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시

        number89 solution = new number89();
        System.out.println(solution.solution(new int[]{1, 1, 4, 7, 7, 5}));

    }
}
