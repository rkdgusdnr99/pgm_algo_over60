import java.util.*;

public class number134 { // 합승 택시 요금
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] newData = new int[fares.length][3];

        for (int i = 0; i < fares.length; i++) {
            newData[i][0] = fares[i][1]; // 도착지를 출발지로
            newData[i][1] = fares[i][0]; // 출발지를 도착지로
            newData[i][2] = fares[i][2]; // 거리는 그대로
        }

        // newData를 원래 배열 data에 더하기
        int[][] modifiedData = new int[fares.length + newData.length][3];
        System.arraycopy(fares, 0, modifiedData, 0, fares.length);
        System.arraycopy(newData, 0, modifiedData, fares.length, newData.length);

        Arrays.sort(modifiedData, Comparator.comparingInt(arr -> arr[0]));

        int[] start = new int[n+1];
        int[] end = new int[n+1];

        start[1] = 0;
        int endNum = 0;
        for (int i = 0; i < modifiedData.length - 1; i++) {
            endNum = modifiedData[i+1][0];
            int startNum = modifiedData[i][0];
            if (startNum != endNum) {
                end[startNum] = i;
                start[endNum] = i + 1;
            }
        }
        end[endNum] = modifiedData.length - 1;

        int[] minDistanceS = dijkstra(modifiedData, n, s, start, end);
        int[] minDistanceA = dijkstra(modifiedData, n, a, start, end);
        int[] minDistanceB = dijkstra(modifiedData, n, b, start, end);

        int min = minDistanceS[a] + minDistanceS[b];
        for (int i = 1; i <= n; i++) {
            if (minDistanceS[i] + minDistanceA[i] != 0 || minDistanceS[i] + minDistanceB[i] != 0 || minDistanceA[i] + minDistanceB[i] != 0)
                min = Math.min(min, minDistanceS[i] + minDistanceA[i] + minDistanceB[i]);
        }

        return min;
    }

    public static int[] dijkstra(int[][] modifiedData, int n, int fir, int[] start, int[] end) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] minDistance = new int[n + 1];
        int now = fir;
        for (int i = 0; i < n-1; i++) {
            for (int j = start[now]; j <= end[now] ; j++) {
                hashSet.add(now);
                int des = modifiedData[j][1];
                if (hashSet.contains(des))
                    continue;
                if (minDistance[des] == 0) {
                    minDistance[des] = minDistance[now] + modifiedData[j][2];
                }
                else {
                    minDistance[des] = Math.min(minDistance[des], minDistance[now] + modifiedData[j][2]);
                }
            }
            int min = 1999999999;
            for (int j = 1; j <= n; j++) {
                if (minDistance[j] != 0 && !hashSet.contains(j) && min > minDistance[j]) {
                    min = minDistance[j];
                    now = j;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };

        int[][] fares1 = {
                {5, 7, 9},
                {4, 6, 4},
                {3, 6, 1},
                {3, 2, 3},
                {2, 1, 6}
        };

        int[][] fares2 = {
                {2, 6, 6},
                {6, 3, 7},
                {4, 6, 7},
                {6, 5, 11},
                {2, 5, 12},
                {5, 3, 20},
                {2, 4, 8},
                {4, 3, 9}
        };

        number134 solution = new number134();
        int result = solution.solution(6,4,6,2,fares);
        System.out.println(result);
        int result1 = solution.solution(7,3,4,1,fares1);
        System.out.println(result1);
        int result2 = solution.solution(6,4,5,6,fares2);
        System.out.println(result2);
    }
    
}

