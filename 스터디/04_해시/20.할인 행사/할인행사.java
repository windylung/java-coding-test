import java.util.HashMap;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        Integer result = 0;

        // 원하는 품목, 수량을 저장하는 해시맵
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 1일차-10일차 동안 원하는 품목 구매 시, 수량 감소
        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            if (map.containsKey(item)) {
                map.put(item, map.get(item) - 1);
            }
        }

        // 1일차 - 10일차에서 1일씩 미루면서 품목 구매 여부 체크
        for (int i = 0; i < discount.length - 10; i++) {
            if (map.values().stream().allMatch(a -> a <= 0)) {
                result++;
            } // 수량이 0 이하일 경우, 원하는 품목을 모두 구매하였다고 판단
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) + 1);
            } // 이전 일자에서 구매한 물품 + 1
            if (map.containsKey(discount[i + 10])) {
                map.put(discount[i + 10], map.get(discount[i + 10]) - 1);
            } // 새로운 일자에서 구매한 물품 -1
        }
        if (map.values().stream().allMatch(a -> a == 0)) {
            result++;
        } // 마지막 일자의 경우, 품목 구매 여부만 체크

        return result;
    }

    public static void main(String[] args) {
        String[] want = new String[] { "banana", "apple", "rice", "pork", "pot" };
        int[] number = new int[] { 3, 2, 2, 2, 1 };
        String[] discount = new String[] { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
                "pork", "rice", "pot", "banana", "apple", "banana" };
        System.out.println("solution(want, number, discount) = " + solution(want, number, discount));
    }
}
