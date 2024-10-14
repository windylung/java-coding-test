import java.util.ArrayDeque;
class Solution {
      public static boolean solution(String s) {

        char[] str = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++) {
            if(str[i] == '('){
                stack.push(str[i]);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek().equals('(')) {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}