package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
    // 그룹 단어 구하기
    // ccazzbb 처럼 연속되면 그룹 단어 ababab 처럼 a,b가 연속되지 않으면 그룹 단어 X
    // 단어 N개를 입력받아 그룹 단어 개수 구하는 프로그램 작성
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단어의 개수 N(100>=N)
        // 단어는 알파벳 소문자로만 되어있고 중복되지 않는다.
        // 단어의 최대 길이는 100
        int N=Integer.parseInt(br.readLine());
        // 출력할 그룹 단어 개수
        int answer=0;
        for (int i = 0; i < N; i++) {
            // 그룹 단어임을 가정하기 위해 1을 추가해놓는다.
            answer++;
            String s = br.readLine();
            boolean[] booleans=new boolean[26];
            // 연속된 문자를 체크하기 위한 tmp
            char tmp=' ';
            for (int j = 0; j < s.length(); j++) {
                char c=s.charAt(j);
                // 이미 한번 나왔던 문자이고 연속된 문자가 아니라면 그룹단어가 아니다
                if(booleans[c-'a'] && tmp!=c) {
                    // 그룹 단어가 아니라면 -1
                    answer--;
                    break;
                }
                // 나온 문자 체크, 연속 문자 확인을 위한 tmp
                tmp=c;
                booleans[c-'a']=true;
            }
        }
        System.out.println(answer);
    }
}
