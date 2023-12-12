import java.util.*;

public class number99 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int min = sequence.length;
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        while (true) {
            try {
                if (sum == k) {
                    if (min > end - start) {
                        min = end - start;
                        answer[0] = start;
                        answer[1] = end;
                        if (start == end)
                            break;
                    }
                    sum = sum + sequence[++end] - sequence[start++];
                }
                else if (sum < k) {
                    sum += sequence[++end];
                }
                else {
                    sum -= sequence[start++];
                }
            }
            catch (Exception e) {
                break;
            }
        }
        return answer;
    }

    public int[] timeOutSolution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = 0;
        for (int i = binarySearch(k, 0, sequence.length-1, sequence); i >= 0; i--) {
            int sum = 0;
            int index = i;
            while (sum < k && index >= 0) {
                sum += sequence[index--];
            }
            if (sum == k) {
                if (len != 0 && len != i -index)
                    break;
                answer[0] = index + 1;
                answer[1] = i;
                len = i-index;
            }
        }
        return answer;
    }

    int binarySearch(int key, int low, int high, int[] arr) {
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        number99 solution = new number99();
        int[] numbers = {1, 2, 3, 4, 5};
        int[] numbers1 = {1, 1, 1, 2, 3, 4, 5};
        int[] numbers2 = {2, 2, 2, 2, 2};
        System.out.println(Arrays.toString(solution.solution(numbers, 7)));
        System.out.println(Arrays.toString(solution.solution(numbers1, 5)));
        System.out.println(Arrays.toString(solution.solution(numbers2, 6)));
    }
}
