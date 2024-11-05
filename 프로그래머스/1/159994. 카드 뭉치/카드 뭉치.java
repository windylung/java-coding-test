class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int card2Idx = 0;

        for (int i = 0; i < goal.length; i++) {
            String goalString = goal[i];
            if (idx1 < cards1.length && cards1[idx1].equals(goalString)) {
                idx1++;
            }else if (card2Idx < cards2.length && cards2[card2Idx].equals(goalString)) {
                card2Idx++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}