import java.util.HashSet;
import java.util.Set;

public class number75 {
    public int mySolution(int[] elements) {
        Set<Integer> elementSum = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int num = 0;
                for (int k = 0; k < i; k++) {
                    num += elements[(j + k)%elements.length];
                }
                elementSum.add(num);
            }
        }
        return elementSum.size();
    }

    public int betterSolution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for(int len = 1;len <= elements.length; len++){
            for(int i = 0;i<elements.length;i++){
                dp[i] += elements[(len+i-1)%elements.length];
                set.add(dp[i]);
            }
        }
        return set.size();
    }

}
