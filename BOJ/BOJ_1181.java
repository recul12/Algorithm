package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1181 {
    /*
        알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하라.
        1. 길이가 짧은 것부터
        2. 길이가 같으면 사전 순으로
        단, 중복된 단어는 하나만 남기고 제거해야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        List<String> words = new ArrayList<>(wordSet);

        Collections.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
