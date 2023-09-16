import java.util.Locale;

public class number66 {
    public static String mySolution(String s) {

        s = Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
        for (int i = 0; i < s.length() - 1; i++) {
            char nextChar = s.charAt(i + 1);
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i + 1) + Character.toUpperCase(nextChar) + s.substring(i + 2);
            }
        }
        return s;
    }

    public String goodSolution(String s) { // 10배 이상 빠르다
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        return answer;
    }
}
