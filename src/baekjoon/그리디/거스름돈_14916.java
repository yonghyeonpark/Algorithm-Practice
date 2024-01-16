package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int change = Integer.parseInt(input);
        int count = 0;

        /*if (change == 1 || change == 3) {
            System.out.println(-1);
            return;
        }
        if (change % 5 == 0) {
            count = change / 5;
        }
        if (change % 5 != 0) {
            count += change / 5;
            int tem = change % 5;
            if (tem % 2 == 0) {
                count += tem / 2;
            }
            if (tem % 2 != 0) {
                count += ((tem + 5) / 2) - 1;
            }
        }*/

        if (change == 1 || change == 3) {
            System.out.println(-1);
            return;
        }
        while (true) {
            if (change % 5 == 0) {
                count += change / 5;
                break;
            }
            change -= 2;
            count++;
        }
        System.out.println(count);
    }
}
