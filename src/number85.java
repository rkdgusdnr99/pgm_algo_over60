public class number85 {
    public int shortSolution(int n, int k) {

        int ans = 0;
        String temp[] = Integer.toString(n, k).split("0");

        Loop : for(String t : temp) {
            if(t.length() == 0) continue;
            long a = Long.parseLong(t);
            if(a == 1) continue;
            for(int i=2; i<=Math.sqrt(a); i++)
                if(a%i == 0) continue Loop;

            ans++;
        }
        return ans;
    }
    public int solution(int n, int k) {
        int answer = 0;
        long sum = 0;
        long digit = 1;
        while (n > 0) {
            int num = n % k;
            if (num == 0) {
                System.out.println(sum);
                if(isPrime(sum))
                    answer++;
                sum = 0;
                digit = 1;
            }
            else {
                sum += num * digit;
                digit *= 10;
            }
            n /= k;
        }
        System.out.println(sum);
        if(isPrime(sum))
            answer++;
        return answer;
    }

    boolean isPrime(long num) {
        if (num <= 1) {
            return false; // 0 또는 음수는 소수가 아님
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // 소수가 아님
            }
        }
        return true; // 소수임
    }

    public static void main(String[] args) {
        number85 solution = new number85();
        System.out.println(solution.solution(437674, 3));
    }
}
