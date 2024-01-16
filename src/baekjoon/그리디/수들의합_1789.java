package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        int count = 1;
        for (int i = 1; ; i++) {
            s -= i;
            if (s == 0) {
                break;
            }
            if (s < 0) {
                count--;
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
