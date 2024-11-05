class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; // cards1의 인덱스
        int idx2 = 0; // cards2의 인덱스

        for (int i = 0; i < goal.length; i++) {
            String goalString = goal[i]; // 찾는 문자열
            if (idx1 < cards1.length && cards1[idx1].equals(goalString)) { // cards1에 해당 문자열이 있는 경우
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(goalString)) { // cards2에 해당 문자열이 있는 경우
                idx2++;
            } else {
                return "No"; // cards1, 2에 모두 없는 경우
            }
        }
        return "Yes"; // goal 문자열을 모두 찾은 경우
    }
}