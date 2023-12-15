package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bracket_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String data = br.readLine();
            while (true) {
                if (!data.contains("()")) {
                    break;
                }
                data = data.replaceAll("\\(\\)", "");
            }
            if (data.isEmpty()) {
                System.out.println("YES");
            }
            if (!data.isEmpty()) {
                System.out.println("NO");
            }
        }
    }
}
