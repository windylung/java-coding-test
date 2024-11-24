

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public  int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = new int[enroll.length];
        int[] memberParent = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        List<String> members = new ArrayList<>(Arrays.asList(enroll));
        for(int i = 0; i < referral.length; i++){
            if(referral[i].equals("-")){
                memberParent[i] = -1;
            }else{
                String parent = referral[i];
                memberParent[i] = map.get(parent);
            }
        }
        System.out.println("memberParent = " + Arrays.toString(memberParent));

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int idx = map.get(sellerName);
            float sellerCost = amount[i] * 100;
            while(memberParent[idx] != -1){
                int a = (int) Math.ceil(sellerCost * 0.9);
                int b = (int) Math.floor(sellerCost * 0.1);

                answer[idx] += a;
                sellerCost = b;

                idx = memberParent[idx];
            }
            answer[idx] +=  (int) Math.ceil(sellerCost * 0.9);
        }
        return answer;
    }
}
