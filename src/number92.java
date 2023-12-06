import java.util.*;
public class number92 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeTruckTime = new LinkedList<>();
        long sum = 0;
        int time = 0;
        int index = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            sum += truck_weights[i];
            time++;
            while (!bridgeTruckTime.isEmpty() && bridgeTruckTime.peek() <= time) {
                bridgeTruckTime.poll();
                sum -= truck_weights[index++];
            }
            if (sum > weight || bridgeTruckTime.size() >= bridge_length) {
                if (bridgeTruckTime.size() >= bridge_length) {
                    sum -= truck_weights[index++];
                    time = bridgeTruckTime.poll();
                }
                while (sum > weight) {
                    sum -= truck_weights[index++];
                    time = bridgeTruckTime.poll();
                }
            }
            bridgeTruckTime.add(time + bridge_length);
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        number92 solution = new number92();
        System.out.println(solution.solution(2,10, new int[]{7, 4, 5, 6}));
        System.out.println(solution.solution(100,100, new int[]{10}));
        System.out.println(solution.solution(100,100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
