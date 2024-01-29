package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// List는 순서 보장이 되기 때문에 나이만 정렬하면 이름은 들어온 순서가 유지된다.
class Member {

    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class 나이순정렬_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age  = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }
        members = members.stream()
                .sorted(Comparator.comparing(m -> m.age))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age)
                    .append(" ")
                    .append(member.name)
                    .append("\n");
        }
        System.out.println(sb);
    }
}
