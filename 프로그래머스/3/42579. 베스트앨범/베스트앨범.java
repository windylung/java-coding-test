
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entries = totalPlays.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        for (int i = 0; i < entries.size(); i++) {
            String genre = entries.get(i).getKey();
            HashMap<Integer, Integer> songs = new HashMap<>();

            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(genre)){
                    songs.put(j, plays[j]);
                }
            }
            List<Map.Entry<Integer, Integer>> songList = songs.entrySet()
                    .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

            answer.add(songList.get(0).getKey());
            if(songList.size()>1){
                answer.add(songList.get(1).getKey());
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
