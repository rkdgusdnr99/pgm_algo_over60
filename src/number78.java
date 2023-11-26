public class number78 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int line1 = arr1[0].length;
        int line2 = arr2[0].length;
        int row1 = arr1.length;
        int[][] answer = new int[line2][line1];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < line2; j++) {
                int temp = 0;
                for (int k = 0; k < line1; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}
