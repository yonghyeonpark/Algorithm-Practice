package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// root 지정
public class 트리_1068 {

    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static boolean[] v;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        v = new boolean[n];
        st = new StringTokenizer(br.readLine());
        int del = Integer.parseInt(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                root = i;
            }
            if (x != -1 && i != del) {
                tree.get(i).add(x);
                tree.get(x).add(i);
            }
        }
        dfsForDel(del);
        if (!v[root]) {
            dfs(root);
        }
        System.out.println(result);
    }

    private static void dfsForDel(int x) {
        v[x] = true;
        for (int i = 0; i < tree.get(x).size(); i++) {
            int y = tree.get(x).get(i);
            if (!v[y]) {
                dfsForDel(y);
            }
        }
    }

    private static void dfs(int x) {
        v[x] = true;
        boolean checkLeaf = true;
        for (int i = 0; i < tree.get(x).size(); i++) {
            int y = tree.get(x).get(i);
            if (!v[y]) {
                checkLeaf = false;
                dfs(y);
            }
        }
        if (checkLeaf) {
            result++;
        }
    }
}
