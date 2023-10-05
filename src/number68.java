public class number68 {
    public int solution(int n) {
        long answer = fibonacci(n);
        return (int)(answer % 1234567);
    }
    public int timeOutFibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return timeOutFibonacci(n-1) + timeOutFibonacci(n-2);
    }
    public int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int num0 = 0;
        int num1 = 1;
        int num2 = 1;
        for(int i = 2; i <= n; i++) {
            num2 = num1 + num0;
            num2 %= 1234567;
            num0 = num1;
            num1 = num2;
        }
        return num2;
    }
}
