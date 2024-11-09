import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
            HashMap<String, Integer> map = new HashMap<>();
            Integer result = 0;
            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]);
            }
            for (int i = 0; i < 10; i++) {
                String item = discount[i];
//                if(map.containsKey(item) && map.get(item) > 0) {
                if(map.containsKey(item)) {
                        map.put(item, map.get(item) - 1);
                }
            }
            for(int i = 0; i < discount.length - 10 ; i++){
                if (map.values().stream().allMatch(a -> a <= 0)) {result++;}
                if (map.containsKey(discount[i])) {map.put(discount[i], map.get(discount[i]) + 1);}
//                if (map.containsKey(discount[i + 10]) && map.get(discount[i + 10]) != 0) {
                if (map.containsKey(discount[i + 10])) {
                    map.put(discount[i + 10], map.get(discount[i + 10]) - 1);}
            }
            if (map.values().stream().allMatch(a -> a == 0)) {result++;}

            return result;
        }
}