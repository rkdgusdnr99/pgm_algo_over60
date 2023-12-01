import java.util.*;

public class number83 {
    public int goodSolution(int k, int[][] dungeons) {
        int answer = -1;
        return dfs(k, dungeons);
    }
    int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d : dungeons) {
            int a = d[0], b = d[1];
            if(a <= k) {
                d[0] = 9999;
                cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                d[0] = a;
            }
        }
        return cnt;
    }

    public int wrongSolution(int k, int[][] dungeons) {
        int[][] range = new int[dungeons.length][3];
        for (int i = 0; i < dungeons.length; i++) {
            range[i][0] = dungeons[i][0];
            range[i][1] = dungeons[i][1];
            range[i][2] = dungeons[i][0] - dungeons[i][1];
        }

        int rangeSize = range.length;

        for (int i = 0; i < rangeSize; i++) {
            for (int j = i + 1; j < rangeSize; j++) {
                if (range[j][2] > range[i][2] || (range[j][2] == range[i][2] && range[j][1] > range[i][1])) {
                    int[] temp = range[i];
                    range[i] = range[j];
                    range[j] = temp;
                }
            }
        }

        for (int[] row : range) {
            System.out.println(Arrays.toString(row));
        }

        int max = 0;
        for (int i = 0; i < rangeSize; i++) {
            int temp = 0;
            for (int j = 0; j < rangeSize; j++) {
                int realSize = (i + j) % rangeSize;
                if (range[realSize][0] <= k) {
                    k -= range[realSize][1];
                    temp++;
                }
            }
            max = Math.max(max, temp);
            if (max == rangeSize)
                return max;
        }
        return max;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[][] fares = {
                {80,20},
                {50,40},
                {30,10}
        };

        number83 solution = new number83();
        int result = solution.goodSolution(80,fares);
        System.out.println(result);
    }


}
