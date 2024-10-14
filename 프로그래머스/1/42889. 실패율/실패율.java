
import java.util.Arrays;

class Solution {
    public static int[] solution(int N, int[] stages) {
        double[][] answer = new double[N][2];
        int[] res = new int[N];
        int[] going = new int[N + 2];
        int[] done = new int[N + 2];

    
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            going[stage] += 1;
            for (int j = 1; j <= stage; j++) {
                done[j] += 1;
            }
        }

        
        for (int i = 1; i <= N; i++) {
            answer[i-1][0] = i; 
            if (done[i] == 0) {
                answer[i-1][1] = 0;  
            } else {
                answer[i-1][1] = (double) going[i] / done[i]; 
            }
        }

        Arrays.sort(answer, (a, b) -> {
            if (b[1] == a[1]) {
                return Double.compare(a[0], b[0]);
            } else {
                return Double.compare(b[1], a[1]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            res[i] = (int) answer[i][0];
        }


        return res;
    }
}
