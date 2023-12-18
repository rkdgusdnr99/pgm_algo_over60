import java.util.Arrays;

public class number102 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int [][] maps = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maps[i][j] = columns * i + j + 1;
            }
        }
        int index = 0;
        for (int[] query: queries) {
            int temp = maps[query[0]-1][query[1]-1];
            int copy;
            int min = temp;
            for (int i = query[1]; i < query[3]; i++) {
                copy = maps[query[0]-1][i];
                maps[query[0]-1][i] = temp;
                temp = copy;
                min = Math.min(min, temp);
            }
            for (int i = query[0]; i < query[2]; i++) {
                copy = maps[i][query[3]-1];
                maps[i][query[3]-1] = temp;
                temp = copy;
                min = Math.min(min, temp);
            }
            for (int i = query[3]-2; i >= query[1]-1; i--) {
                copy = maps[query[2]-1][i];
                maps[query[2]-1][i] = temp;
                temp = copy;
                min = Math.min(min, temp);
            }
            for (int i = query[2]-2; i >= query[0]-1; i--) {
                copy = maps[i][query[1]-1];
                maps[i][query[1]-1] = temp;
                temp = copy;
                min = Math.min(min, temp);
            }
            answer[index++] = min;
        }
        return answer;
    }

    public static void main(String[] args) {
        number102 solution = new number102();
//        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//        System.out.println(Arrays.toString(solution.solution(6, 6, queries)));
//        int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
//        System.out.println(Arrays.toString(solution.solution(3, 3, queries2)));
        int[][] queries3 = {{1,1,100,97}};
        System.out.println(Arrays.toString(solution.solution(100, 97, queries3)));
    }
}
