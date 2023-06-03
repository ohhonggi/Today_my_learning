import java.util.*;

class Solution {
    HashMap<String, Integer> sortedGenres = new HashMap<String, Integer>(100);
    HashMap<String, LinkedList<int[]>> sortedPlayCount = new HashMap<String, LinkedList<int[]>>(100);
    public int[] solution(String[] genres, int[] plays) {
        /*
            우선순위
            1. 속한 노래가 많이 재생된 장르 순
            2. 장르내 많이 재생된 노래
                1) 재생 횟수가 같은경우, 고유 번호가 낮은 노래
                (최대 두 개까지)
            
            1. 장르 by 재생 횟수 count
            2. 장르 내 노래 by 재생 횟수 정렬
                3. 재생 횟수가 같은 경우, 고유 번호가 낮은 순 정렬
                
        */
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        for (int i = 0; i<genres.length; i++){
            String genre = genres[i];
            
            sortedGenres.put(genre, sortedGenres.getOrDefault(genre, 0) + plays[i]);
            
            LinkedList<int[]> temp = sortedPlayCount.getOrDefault(genre, new LinkedList<int[]>());
            temp.add(new int[]{plays[i], i});
            
            if (temp.size() >= 2){
                Collections.sort(temp, (int[] a, int[] b) -> 
                    a[0] != b[0] ? -Integer.compare(a[0],b[0]) :
                                Integer.compare(a[1],b[1]));
                if (temp.size() > 2)
                    temp.removeLast();
            }
                
            sortedPlayCount.put(genre, temp);
        }
        
        List<Map.Entry<String,Integer>> list = 
            new LinkedList<Map.Entry<String,Integer>>(sortedGenres.entrySet());
        
        Collections.sort(list, (Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) ->
            -a.getValue().compareTo(b.getValue()));
        
        for (Map.Entry<String,Integer> genre : list){
            String g = genre.getKey();
            LinkedList<int[]> play = sortedPlayCount.get(g);
            
            for (int[] p : play)
                result.add(p[1]);
        }
        
        
        
        int[] answer = new int[result.size()];
        Integer[] resultA = result.toArray(new Integer[result.size()]);
        for (int i = 0; i < result.size(); i++){
            answer[i] = resultA[i];
        }
        
        return answer;
    }
    
}