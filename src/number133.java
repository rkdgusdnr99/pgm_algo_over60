import java.util.Arrays;

public class number133 {
    public int myBestSolution(int[][] triangle) { // 가장 빠르고 가장 간결하다.
        int high = triangle.length;
        for (int i = high-2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }

    public int ascBestSolution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

    public int ascSolution(int[][] triangle) {
        int answer = 0;
        int high = triangle.length;
        int wide = triangle[high-1].length;
        int[][] cotingTriangle = new int[high][wide+1];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j <= i; j++) {
                cotingTriangle[i][j + 1] = triangle[i][j];
            }
        }

        for (int i = 1; i < high; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                cotingTriangle[i][j+1] += Math.max(cotingTriangle[i-1][j+1], cotingTriangle[i-1][j]);
            }
        }
        for (int i = 0; i < wide; i++) {
            answer = Math.max(answer, cotingTriangle[high-1][i+1]);
        }

        return answer;
    }

    public int timeOutSolution(int[][] triangle) {
        int answer = 0;
        int high = triangle.length - 1;
        int wide = triangle[high].length - 1;

        for (int i = 0; i <= wide; i++) {
            answer = Math.max(answer, getSum(triangle, i));
        }

        return answer + triangle[0][0];
    }

    public static int getSum(int[][] triangle, int temp) {
        int answer = 0;
        int high = triangle.length - 1;
        for (int i = high; i > 0; i--) {
            if (temp == 0) {
                answer += triangle[i][0];
            }
            else {
                if (triangle[i][temp - 1] >= triangle[i][temp]) {
                    answer += triangle[i][temp - 1];
                    temp--;
                }
                else {
                    answer += triangle[i][temp];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        number133 solution = new number133();
//        int result = solution.solution(triangle);
//        System.out.println("최대 합: " + result);
    }
}
