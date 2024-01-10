package baekjoon.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 방문 여부 미체크 -> 메모리 초과
 * 그래프 양방향 설정
 */
public class 바이러스_2606 {

    private static int count = 0;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x); // 양방향 설정
        }
        System.out.println(search(1));
    }

    private static int search(int com) {
        visited[com] = true;
        for (int i = 0; i < graph.get(com).size(); i++) {
            if (!visited[graph.get(com).get(i)]) {
                count++;
                search(graph.get(com).get(i));
            }
        }
        return count;
    }
}
