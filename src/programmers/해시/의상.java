package programmers.해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Map 메서드 복기
public class 의상 {

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes1));
    }

    private static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String[] i : clothes) {
            ArrayList<String> list = map.computeIfAbsent(i[1], value -> new ArrayList<>());
            list.add(i[0]);
        }

        int com = 1;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            com *= entry.getValue().size() + 1;
        }
        return com - 1;
    }
}
