package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {
    /*
        한 줄에 글자들을 빈칸없이 연속으로 나열해서 최대 15개의 글자로 이루어진 단어로 만들려고 한다.
        영어 대문자, 소문자, 숫자를 이용하여 단어를 5개 만들 것이다.
        그리고 만들어진 5개의 단어들을 세로로 읽는다.
        이 때, 세로로 읽다가 그 자리에 글자가 없다면 다음 글자를 읽는다.
        세로로 읽은 순서대로 글자들을 공백없이 출력하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] words = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                words[i][j] = tmp.charAt(j);
            }
            for (int j = tmp.length(); j < 15; j++) {
                words[i][j] = '*';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(words[j][i] == '*') continue;
                sb.append(words[j][i]);
            }
        }

        System.out.println(sb);
    }
}
