
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for(String line : record){
            String[] word = line.split(" ");;
            if(word[0].equals("Enter") || word[0].equals("Change")){
                map.put(word[1], word[2]);
            }
        }


        for(String line : record){
            String[] word = line.split(" ");
            if(word[0].equals("Enter")){
                String name = map.get(word[1]);
                answer.add(name +"님이 들어왔습니다.");
            }else if(word[0].equals("Leave")){
                String name = map.get(word[1]);
                answer.add(name +"님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[0]);
    }
}