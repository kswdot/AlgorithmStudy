import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 메세지를 담을 해시맵 생성
        HashMap<String, String> message = new HashMap<>();
        
        message.put("Enter", "님이 들어왔습니다.");
        message.put("Leave", "님이 나갔습니다.");
        
        // key: 유저 아이디, value: 닉네임
        HashMap<String, String> user = new HashMap<>();
        
        // record 나누기
        for (String string : record) {
            String[] arr = string.split(" ");
            if (arr[0].equals("Enter") || arr[0].equals("Change")) {
                user.put(arr[1], arr[2]);
            }
        }
        
        // 답을 저장할 리스트
        ArrayList<String> answer = new ArrayList<>();
        
        for (String string : record) {
            String[] arr = string.split(" ");
            if (message.containsKey(arr[0])) {
                answer.add(user.get(arr[1]) + message.get(arr[0]));
            }
        }
        
        return answer.toArray(String[]::new);
    }
}