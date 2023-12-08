import java.util.*;

public class number94 {
    public int solution(String numbers) {
        String[] num = numbers.split("");
        Set<Integer> set = new HashSet<>();
        recursion(num, set, "");
        return set.size();
    }

    void recursion(String[] numbers, Set<Integer> set, String num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("x"))
                continue;
            String sNumber = num + numbers[i];
            int number = Integer.parseInt(sNumber);
            if (isPrime(number))
                set.add(number);
            String temp = numbers[i];
            numbers[i] = "x";
            recursion(numbers, set, sNumber);
            numbers[i] = temp;
        }
    }
    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        double squareRoot = Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        number94 solution = new number94();
        System.out.println(solution.solution("011"));
    }
}
