
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
 public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> speedQueue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            queue.add(progresses[i]);
        }
        for(int i = 0; i < speeds.length; i++){
            speedQueue.add(speeds[i]);
        }

        int days = (int)(Math.ceil((100.0-queue.poll())/speedQueue.poll()));

        while(!queue.isEmpty()){
            if(queue.peek() + speedQueue.peek() * days >= 100){
                queue.poll();
                speedQueue.poll();
                cnt++;
            }else{
                answer.add(cnt);
                cnt = 1;
                days = (int)(Math.ceil((100.0-queue.poll())/speedQueue.poll()));
            }
        }
        if(cnt > 0){
            answer.add(cnt);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
