import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class number61 {
    public int[] mySolution(String today, String[] terms, String[] privacies) {
        int[] firAnswer = new int[privacies.length];

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate todayDate = LocalDate.parse(today, dateFormatter);
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] parts = term.split(" ");
            String key = parts[0];
            int value = Integer.parseInt(parts[1]);
            termMap.put(key, value);
        }

        int index1 = 1;
        int index2 = 0;
        for (String s: privacies) {
            String[] parts = s.split(" ");
            int term = termMap.get(parts[1]);
            LocalDate privaciesDate = LocalDate.parse(parts[0], dateFormatter);
            LocalDate targetDate = privaciesDate.plusMonths(term);

            if (!targetDate.isBefore(todayDate)) {
                firAnswer[index2++] = index1;
            }
            index1 ++;
        }

        int[] answer = Arrays.copyOf(firAnswer, index2);
        return answer;
    }

    public int[] goodSolution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
