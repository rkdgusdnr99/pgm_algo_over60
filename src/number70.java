public class number70 {
    public int crazySolution(int n, int a, int b)
    {
        return Integer.toBinaryString((a-1)^(b-1)).length();
    }
    public int mySolution(int n, int a, int b)
    {
        int answer = 0;

        while (a != b) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
