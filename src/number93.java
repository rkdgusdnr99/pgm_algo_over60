import java.util.*;

public class number93 {
    public String solution(int[] numbers) {
        String answer = "";
        String[][] sNumber = new String[numbers.length][2];
        for (int i = 0; i < numbers.length; i++) {
            sNumber[i][1] = Integer.toString(numbers[i]);
            StringBuilder sb = new StringBuilder(sNumber[i][1]);
            while (sb.length() < 4) {
                sb.append(sNumber[i][1]);
            }
            sNumber[i][0] = sb.substring(0, 4);
        }
        Arrays.sort(sNumber, Comparator.comparing(o -> o[0]));

        for (int i = numbers.length-1; i >= 0; i--) {
            answer += sNumber[i][1];
        }
        for (String[] row : sNumber) {
            System.out.println(row[0] + " - " + row[1]);
        }
        if(answer.charAt(0) == '0')
            return "0";
        return answer;
    }

        public static void main(String[] args) {
            number93 solution = new number93();
            int[] numbers = {0, 0, 0};
            String[] arr = {"10", "11", "9", "53", "59", "5"};
            System.out.println(solution.solution(numbers));
        }
}

//5665656555555554954544
//5665656555555554954544