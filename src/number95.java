import java.util.Arrays;

public class number95 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        recursion(arr, answer);
        return answer;
    }

    void recursion(int[][] arr, int[] sum) {
        if (arr.length == 1) {
            sum[arr[0][0] == 0 ? 0 : 1]++;
        }
        else {
            int rows = arr.length;
            int cols = arr[0].length;

            int[][] arr1 = new int[rows / 2][cols / 2];
            int[][] arr2 = new int[rows / 2][cols / 2];
            int[][] arr3 = new int[rows / 2][cols / 2];
            int[][] arr4 = new int[rows / 2][cols / 2];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i < rows / 2 && j < cols / 2) {
                        arr1[i][j] = arr[i][j];
                    } else if (i < rows / 2 && j >= cols / 2) {
                        arr2[i][j - cols / 2] = arr[i][j];
                    } else if (i >= rows / 2 && j < cols / 2) {
                        arr3[i - rows / 2][j] = arr[i][j];
                    } else {
                        arr4[i - rows / 2][j - cols / 2] = arr[i][j];
                    }
                }
            }
            int originZero = sum[0];
            int originOne = sum[1];
            recursion(arr1, sum);
            recursion(arr2, sum);
            recursion(arr3, sum);
            recursion(arr4, sum);

            if (originOne - sum[1] == 0)
                sum[0] -= 3;
            else if (originZero - sum[0] == 0)
                sum[1] -= 3;
        }
    }

    public static void main(String[] args) {
        number95 solution = new number95();

//        int arr[][] = {
//              {1,1,0,0},
//              {1,0,0,0},
//              {1,0,0,1},
//              {1,1,1,1}
//      };
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution.solution(arr)));
    }

    // 배열 4등분 과정이 좀 더 깔끔한 풀이
    int one = 0, zero = 0;
    void press(int[][] arr, int xs, int xe, int ys, int ye){
        int oneCnt = 0, max = (int)Math.pow(xe - xs, 2);
        for(int i = xs; i < xe; i++){
            for(int j = ys; j < ye; j++){
                oneCnt += arr[i][j];
            }
        }
        if(oneCnt == 0) zero++;
        else if(oneCnt == max) one++;
        else {
            int xm = (xe + xs) / 2;
            int ym = (ye + ys) / 2;
            press(arr, xs, xm, ys, ym);
            press(arr, xm, xe, ys, ym);
            press(arr, xs, xm, ym, ye);
            press(arr, xm, xe, ym, ye);
        }
    }
    public int[] goodSolution(int[][] arr) {
        press(arr, 0, arr.length, 0, arr.length);
        return new int[]{zero, one};
    }
}