import java.util.*;
class Solution {

    public static ArrayList<HashMap<String, Integer>> hmarrayList;
    public static String[] dishesList;
    public static HashMap<String, Integer> freqMap = new HashMap<>();

    public static int calculate(Stack<String> stack) {
        int res = 0;
        for (HashMap<String, Integer> map : hmarrayList) {
            boolean allContain = true;
            for (String s : stack){
                if (!map.containsKey(s)){
                    allContain = false;
                }
            }
            if (allContain){
                res += 1;
            }
        }
        freqMap.put(String.join("", stack), res);
        return res;
    }

    public static void backtracking(Stack<String> stack, int idx, int size, List<Stack<String>> stacks) {
        if(stack.size() == size){
            Stack<String> cloneStack = (Stack<String>) stack.clone();
            stacks.add(cloneStack);
            return ;
        }
        String key = String.join("", stack);
        if(freqMap.containsKey(key) && freqMap.get(key) < 2){
            return ;
        }
        for (int i = idx; i < dishesList.length; i++) {
            stack.add(dishesList[i]);
            backtracking(stack, i+1, size, stacks);
            stack.pop();
        }
    }


    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> dishes = new ArrayList<>();
        ArrayList<HashMap<String, Integer>> hashMapArrayList = new ArrayList<>();
        for (String order : orders) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            String[] line = order.split("");
            for (String s : line) {
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
                if(!dishes.contains(s)){
                    dishes.add(s);
                }
            }
            hashMapArrayList.add(hashMap);
        }

        hmarrayList = hashMapArrayList;
        Collections.sort(dishes);
        dishesList = dishes.toArray(new String[0]);

        for (int size : course) {
            if (dishes.size() < size) {
                break;
            }
            Stack<String> stack = new Stack<>();
            List<Stack<String>> stacks = new ArrayList<>();
            backtracking(stack, 0, size, stacks);


            ArrayList<String> bestStack = new ArrayList<>();
            int max = 2;
            for (Stack<String> s : stacks) {
                int resCal = calculate(s);
//                System.out.println("resCal = " + resCal);
                if (max < resCal) {
                    max = resCal;
                    bestStack.clear();
                    bestStack.add(String.join("", s));
                } else if (max == resCal) {
                    bestStack.add(String.join("", s));
                }
            }
            answer.addAll(bestStack);
            Collections.sort(answer);
//            System.out.println("size = " + size + "bestStack" + bestStack);
        }
        return answer.toArray(new String[0]);
    }
}