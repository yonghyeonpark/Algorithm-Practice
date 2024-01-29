package programmers.해시;

import java.util.*;

// thenComparing 활용
public class 베스트앨범 {

    public static void main(String[] args) {
        String[] gemres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(gemres, plays);
    }

    private static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalCount = new TreeMap<>();
        Map<String, Map<Integer, Integer>> map = new TreeMap<>();

        // 장르별 총 재생 횟수 및 장르별 각 노래의 재생 횟수 설정
        for (int i = 0; i < genres.length; i++) {
            totalCount.put(genres[i], totalCount.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> subMap = map.computeIfAbsent(genres[i], value -> new TreeMap<>());
            subMap.put(i, plays[i]);
        }

        // 총 재생 횟수의 내림차순으로 엔트리를 정렬
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(totalCount.entrySet());
        Collections.sort(sortedEntries, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sortedEntries.size(); i++) {
            String key = sortedEntries.get(i).getKey();
            Map<Integer, Integer> songs = map.get(key);

            // 해당 키에 해당하는 엔트리를 값에 따라 내림차순으로 정렬
            List<Map.Entry<Integer, Integer>> sortedSongs = new ArrayList<>(songs.entrySet());

            // 값을 기준으로 내림차순, 값이 같을 때는 키를 기준으로 오름차순
            Collections.sort(sortedSongs, Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder())
                    .thenComparing(Map.Entry.comparingByKey()));

            // 결과 리스트에 추가
            result.add(sortedSongs.get(0).getKey());
            if (sortedSongs.size() > 1) {
                result.add(sortedSongs.get(1).getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
