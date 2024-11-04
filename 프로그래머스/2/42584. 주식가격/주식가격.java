import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);

        }
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = prices.length - j - 1;
        }
        return answer;
    }
}