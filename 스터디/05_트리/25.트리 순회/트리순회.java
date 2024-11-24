package Week4.solution23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        HashMap<String, Integer> id = new HashMap<>();
        ArrayList<HashMap<String, Integer>> mapList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            id.put(id_list[i], i);
            mapList.add(new HashMap<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] line = report[i].split(" ");
            // 신고당한 ID
            Integer a = id.get(line[1]);
            HashMap<String, Integer> map = mapList.get(a);

            // 신고한 ID와 신고 횟수
            if (map.containsKey(line[0])) {
                map.put(line[0], map.get(line[0]) + 1);
            } else {
                map.put(line[0], 1);
            }
        }


        for (int i = 0 ; i < id_list.length ; i++) {
            int count = (int) mapList.get(i).values().stream().count();
            if (count >= k){
                Set<String> reporters = mapList.get(i).keySet();
                for (String reporter : reporters) {
                    Integer idx = id.get(reporter);
                    result[idx] += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }
}
