import java.util.*;
import static java.util.stream.Collectors.*;

public class number80 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        Collection<Integer> values = map.values();

        for (int value : values) {
            answer *= (value + 1);
        }

        return answer - 1;
    }

    public int streamSolution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
