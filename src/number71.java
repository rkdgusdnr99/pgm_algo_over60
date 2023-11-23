import java.util.Arrays;

public class number71 {

    public int firstSolution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length - 1];
        int temp = answer;
        while (!allSatisfied(arr, answer)) {
            answer += temp;
        }
        return answer;
    }
    public static boolean allSatisfied(int[] arr, int num) {
        for (int n : arr) {
            if (num % n != 0)
                return false;
        }
        return true;
    }

    //----------------------------------------------------------------------------------------------------

    public int ascSolution(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = getMultiple(arr[i + 1], arr[i]);
        }
        return arr[arr.length - 1];
    }

    public int descSolution(int[] arr) { // 가장 빠름, 작은 수들보다 큰 수들의 최소 공배수 구하는게 더 효과적
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] = getMultiple(arr[i], arr[i - 1]);
        }
        return arr[0];
    }

    public int getMultiple (int max, int min) { // 최소공배수
        for (int i = 1; i <= min; i++) {
            int multiMax = max * i;
            if (multiMax % min == 0)
                return multiMax;
        }
        return min * max;
    }
}

/*
최소 공배수 탐색 효율: 가장 큰 수부터 시작하여 그 다음으로 큰 수와 최소 공배수를 계산하면,
계산해야 하는 범위가 좁아짐.
왜냐하면 가장 큰 수의 배수가 다른 수보다 더 클 확률이 높기 때문.
따라서 해당 수와 이웃한 수의 최소 공배수를 찾는 것이 더 빨리 수렴된다.
 */