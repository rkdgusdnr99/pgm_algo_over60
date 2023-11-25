import java.util.Arrays;

public class number76 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] < i) {
                return i-1;
            }
        }
        return citations.length;
    }

    public int timeOutSolution(int[] citations) {
        Arrays.sort(citations);
        return binarySearch(citations, 0, citations.length);
    }

    static int binarySearch(int[] arr, int low, int high) {
        int mid;
        int len = arr.length;
        while(low <= high) {
            mid = (low + high) / 2;
            int realNum = len - mid;
            if (arr[mid] == realNum) {
                return realNum;
            } else if (arr[mid] < realNum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return len-low; // 탐색 실패
    }
}
