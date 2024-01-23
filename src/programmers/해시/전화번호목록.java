package programmers.해시;

import java.util.HashMap;
import java.util.Map;

// containsValue()를 사용하면 맵의 어떤 엔트리에 값이 존재하는지 확인하기 때문에 모든 엔트리를 순회하면서 값을 비교하는데, 이로 인해 성능이 떨어질 수 있습니다.
public class 전화번호목록 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        int a = 0;
        for (String num : phone_book) {
            map.put(num, a++);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String num = entry.getKey();
            for (int i = 1; i < num.length(); i++) {
                if (map.containsKey(num.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
