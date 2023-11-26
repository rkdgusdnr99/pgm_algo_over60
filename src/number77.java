public class number77 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;

        // 값들을 직접 계산하여 배열에 저장
        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);
            int val = (row <= col) ? col + 1 : row + 1;
            answer[index++] = val;
        }

        return answer;
    }

    public int[] timeOutSolution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        int ln = (int)(left / n);
        int rn = (int)(right / n);
        int start = (int)(left % n);
        int end = (int)(right % n);

        int index = 0;
        for (int i = start; i < ln; i++) {
            answer[index++] = ln;
        }
        for (int i = Math.max(start, ln); i < n; i++) {
            answer[index++] = i+1;
        }
        for (int i = ln+1; i < rn; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = i+1;
            }
            for (int j = i+1; j < n; j++) {
                answer[index++] = j+1;
            }
        }
        for (int i = 0; i < rn; i++) {
            answer[index++] = rn+1;
        }
        for (int i = rn; i <= end; i++) {
            answer[index++] = i+1;
        }
        return answer;
    }
    public int[] memoryOutSolution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        int[][] arr = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i][j] = i + 1;
            }
            for (int j = i; j < n; j++) {
                arr[i][j] = j + 1;
            }
        }

        for (long i = left; i <= right; i++) {
            answer[index++] = arr[(int)(i/n)][(int)(i%n)];
        }
        return answer;
    }
}
