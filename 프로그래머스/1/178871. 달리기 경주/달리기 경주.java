import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> indexNameMap = new HashMap<>();
        Map<String, Integer> nameIndexMap = new HashMap<>();

        for (int i=0; i<players.length; i++) {
            indexNameMap.put(i, players[i]);
            nameIndexMap.put(players[i], i);
        }

        for (int i=0; i<callings.length; i++) {
            // 추월한 사람
            int callerNumber = nameIndexMap.get(callings[i]);
            // 추월한 사람의 현재 순위를 조정 -> 앞으로 이동
            nameIndexMap.put(callings[i], nameIndexMap.get(callings[i]) - 1);
            

            // 추월당한 사람
            String prevName = indexNameMap.get(callerNumber - 1);
            int prevNumber = nameIndexMap.get(prevName);
            nameIndexMap.put(prevName, nameIndexMap.get(prevName) + 1);
            
            // IndexNameMap에 순위 적용
            indexNameMap.put(callerNumber - 1, callings[i]);
            indexNameMap.put(callerNumber, prevName);
        }
        
        String[] result = new String[players.length];
        
        for (int i=0; i<result.length; i++) {
            result[i] = indexNameMap.get(i);
        }


        
        return result;
    }
}