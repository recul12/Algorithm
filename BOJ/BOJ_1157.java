package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157{
    // 알파벳 대소문자로 된 단어가 주어진다
    // 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 출력하라
    // 대문자 소문자 구분 X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 개수 26개 배열
        int[] alpha = new int[26];
        String s = br.readLine();

        // 문자 하나씩 아스키코드와 비교해보고 나온 알파벳 배열의 개수를 올린다
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 대문자
            if('A' <= c && c <= 'Z') alpha[c-'A']++;
            // 소문자
            else alpha[c-'a']++;
        }

        // 가장 많이 사용된 알파벳 구하기

        int max = 0;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            // 알파벳 개수가 max보다 높다면 max를 answer에 저장해준다.
            if(alpha[i] > max){
                max = alpha[i];
                // answer에 알파벳 순서 i 와 대문자 변환을 위한 65를 더해준다.
                answer = (char)(i+65);
            }
            // 알파벳 배열이 max보다 같은 경우에 ? 출력을 위해 ? 문자 저장
            else if(alpha[i] == max){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
