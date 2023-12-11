import java.util.Arrays;

public class number98 {
    public int[] solution(int n) {
        int[] answer = new int[arithmetic(n)];
        int[][] temp = new int[n][n];
        int index = 1;
        int y = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                for (int j = 0; j < n - i; j++) {
                    temp[y++][x] = index++;
                }
                x++;
                y--;
            }
            else if (i % 3 == 1) {
                for (int j = 0; j < n - i; j++) {
                    temp[y][x++] = index++;
                }
                x-=2;
                y--;
            }
            else {
                for (int j = 0; j < n - i; j++) {
                    temp[y--][x--] = index++;
                }
                x++;
                y+=2;
            }
        }
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = temp[i][j];
            }
        }
        return answer;
    }
    public int arithmetic(int n) {
        int x = 0;
        for (int i = 1; i <= n; i++)
            x += i;
        return x;
    }

    public static void main(String[] args) {
        number98 solution = new number98();
        System.out.println(Arrays.toString(solution.solution(5)));
    }
}
