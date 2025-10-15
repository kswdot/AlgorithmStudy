import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 수 정리 => key:장르 value:장르별 노래 재생 횟수
        HashMap<String, Integer> genreCount = new HashMap<>();
        // 장르 별 곡 목록 => key:장르 value:[노래 인덱스, 노래 재생 횟수]
        HashMap<String, List<int[]>> genreSong = new HashMap<>();
        
        // 맵 채우기
        for (int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            if (!genreSong.containsKey(genres[i])) {
                genreSong.put(genres[i], new ArrayList<>());
            }
            
            genreSong.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 장르 별 재생 수 내림차순
        List<String> genreOrder = new ArrayList<>(genreCount.keySet());
        genreOrder.sort((a, b) -> genreCount.get(b) - genreCount.get(a)); 
        
        List<Integer> answer = new ArrayList<>();
        
        // 장르 내 재생 수 내림차순
        for (String g : genreOrder) {
            List<int[]> list = genreSong.get(g);
            list.sort((a, b) -> {
                if (b[1] != a[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            });
            
            int take = Math.min(2, list.size());
            for (int i = 0; i < take; i++) answer.add(list.get(i)[0]);
        }
        
        // 리스트 -> 배열
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}