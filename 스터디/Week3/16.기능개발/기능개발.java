
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1; // 한 번에 배포되는 작업 개수
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> speedQueue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }
        for (int i = 0; i < speeds.length; i++) {
            speedQueue.add(speeds[i]);
        }

        int days = (int) (Math.ceil((100.0 - queue.poll()) / speedQueue.poll())); // 첫 번째 작업 완료에 걸리는 최소 일 수

        while (!queue.isEmpty()) { // 잔여 작업이 있을 때까지
            if (queue.peek() + speedQueue.peek() * days >= 100) { // 같은 일 수 내에 작업이 완료되는 경우
                queue.poll();
                speedQueue.poll();
                cnt++;
            } else { // 같은 일 수 내에 작업이 완료되지 못하는 경우
                answer.add(cnt); // 한 번에 배포되는 작업의 개수 answer에 저장
                cnt = 1;
                days = (int) (Math.ceil((100.0 - queue.poll()) / speedQueue.poll())); // 해당 작업 완료에 걸리는 최소 일 수
            }
        }
        answer.add(cnt); // 마지막으로 배포되는 작업의 개수 answer에 저장
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
