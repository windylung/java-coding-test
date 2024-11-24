
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static int solution(int N, int K){
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1); // 번호표 지급
        }
        while(queue.size() > 1) { // 마지막 한 명 남을 때까지 K번 째 사람을 없애는 것을 반복
            for (int i=0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.peek();
    }
}

