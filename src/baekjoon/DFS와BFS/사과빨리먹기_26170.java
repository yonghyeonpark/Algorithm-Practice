package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과빨리먹기_26170 {

    private static int[][] map = new int[5][5];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int minMoving = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 맵 저장
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 학생 위치
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int moving = 0;
        int eating = 0;
        move(x, y, moving, eating);
        if (minMoving == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minMoving);
        }
    }

    public static void move(int x, int y, int moving, int eating) {
        if (map[x][y] == 1) {
            eating++;
        }
        if (eating == 3) {
            if (moving < minMoving) {
                minMoving = moving;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 4 || nx < 0 || ny > 4 || ny < 0 || map[nx][ny] == -1) {
                continue;
            }
            int tem = map[x][y];
            map[x][y] = -1;
            move(nx, ny, moving + 1, eating);
            map[x][y] = tem;
        }
    }
}
