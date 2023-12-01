import java.util.*;

public class number84 {
    int answer = 0;
    public int goodSolution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    private void dfs(int sum, int idx, int[] numbers, int target) {
        if (idx == numbers.length && sum == target) {
            answer++;
            return;
        }
        if (idx >= numbers.length) {
            return;
        }
        dfs(sum + numbers[idx], idx + 1, numbers, target);
        dfs(sum - numbers[idx], idx + 1, numbers, target);
    }

    public int timeOutSolution2(int[] numbers, int target) {
        int total = 0;
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int num : numbers) {
            numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
            total += num;
        }
        HashSet<Integer> set = new HashSet<>();
        return timeOutDfs2(numberCount, set, target, total);
    }

    int timeOutDfs2(Map<Integer, Integer> numberCount, HashSet<Integer> set, int target ,int total) {
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (total == target) {
                return 1;
            }
            if (!set.contains(key)) {
                for (int i = 1; i <= value; i++) {
                    if (total > target) {
                        set.add(key);
                        int num = timeOutDfs2(numberCount, set, target, total - key * i * 2);
                        if (num > 0)
                            cnt += combination(value, i);
                        set.remove(key);
                    }
                    else {
                        return -9999;
                    }
                }
            }
        }
        return cnt;
    }

    int combination (int n, int r) {
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        for (int i = 1; i <= r; i++) {
            num /= i;
        }
        for (int i = 1; i <= n - r ; i++) {
            num /= i;
        }
        return (int)num;
    }

    public int timeOutSolution(int[] numbers, int target) {
        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = len-1; i >= 0; i--) {
            if (total - numbers[i] * 2 < target) {
                numbers[i] = 0;
                len--;
            }
        }

        int[] numCopy = new int[len];
        for (int i = 0; i < len; i++) {
            numCopy[i] = numbers[len-i-1];
        }
        int[] check = new int[len];
        HashSet<String> set = new HashSet<>();

        return timeOutDfs(numCopy, check, target, total, set);
    }

    int timeOutDfs(int[] numbers, int[] check, int target, int total, HashSet<String> set) {
        for (int i = 0; i < numbers.length; i++) {
            if (check[i] == 0) {
                if (total == target) {
                    int[] newArray = Arrays.copyOf(check, check.length);
                    set.add(Arrays.toString(newArray));
                    break;
                }
                else if (total > target) {
                    check[i] = 1;
                    timeOutDfs(numbers, check, target, total - numbers[i] * 2, set);
                    check[i] = 0;
                }
                else
                    break;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[] num1 = {1,1,1,1,1};
        int[] num2 = {4,1,2,1};

        number84 solution = new number84();
//        int result = solution.solution(num1,3);
//        System.out.println(result);
//        System.out.println(solution.solution(num2,4));
    }

}
