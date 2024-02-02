package baekjoon.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 이진 탐색
public class 숫자카드_10815 {

    private static int n;
    private static List<Integer> cards = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }
        cards = cards.stream()
                .sorted()
                .collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num)) {
                result.add(1);
                continue;
            }
            result.add(0);
        }
        result.forEach(a -> System.out.print(a + " "));
    }

    private static boolean binarySearch(int num) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = cards.get(mid);

            if (num < midValue) {
                high = mid - 1;
            } else if (num > midValue) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
