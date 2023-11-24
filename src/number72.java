public class number72 {
    public long solution(int n) { // 가장 빠름
        long fir = 1;
        long sec = 2;
        for (int i = 3; i <= n; i++) {
            long temp = fir;
            fir = sec;
            sec = sec + temp;
            fir %= 1234567;
            sec %= 1234567;
        }
        if (n == 1)
            return fir;
        return sec;
    }

    public long timeOutSolution(int n) {
        return fibonacci(n);
    }

    public static long fibonacci(int n) { // 재귀
        if (n == 1) { // 기본 케이스
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else { // 재귀 케이스
            return (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
        }
    }

    static long[] memo;

    public long memoizationSolution(int n) {
        memo = new long[n + 1]; // 이전 결과를 저장할 배열 초기화
        for (int i = 0; i <= n; i++) {
            memo[i] = -1; // 메모 배열을 -1로 초기화 (계산되지 않은 상태를 나타내기 위해)
        }

        return memoizationFibonacci(n);
    }

    public static long memoizationFibonacci(int n) {
        if (n <= 2) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n]; // 이미 계산된 값이면 메모된 값을 반환
        }

        memo[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2); // 메모이제이션
        memo[n] %= 1234567; // 나누기 연산 적용

        return memo[n];
    }
}
