import java.util.PriorityQueue;

public class number65 {
    public String solution(String s) {
        String[] stringTokens = s.split(" ");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String token : stringTokens) {
            int num = Integer.parseInt(token);
            maxHeap.offer(num);
            minHeap.offer(num);
        }

        String answer = minHeap.peek() + " " + maxHeap.peek();

        return answer;
    }
}