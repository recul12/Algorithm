package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s=br.readLine();
        // 알파벳 대문자 배열
        int alphabet[] = new int[26];
        for(char c : s.toCharArray()){
            alphabet[c-'A']++;
        }

        // 알파벳이 홀수개인 것이 1개라면 가운데에 놓을 수 있지만 2개 이상이면 불가
        int cnt=0;
        for(int x : alphabet){
            if(x%2!=0) cnt++;
        }

        // cnt가 2 이상이면 I'm Sorry Hansoo 출력
        if(cnt>1) sb.append("I'm Sorry Hansoo");
        else{
            for (int i = 0; i < alphabet.length; i++) {
                // 사전 순서대로 펠린드롬이니 알파벳 순서대로
                // 개수에 맞게 절반을 나열하면 된다.
                for (int j = 0; j < alphabet[i]/2; j++) {
                    // 알파벳 번호를 아스키코드로 문자로 변환하여 문자열에 저장
                    sb.append((char)(i+65));
                }
            }
            // cnt가 홀수라면 필요한 가운데 문자
            for (int i = 0; i < alphabet.length; i++) {
                if(alphabet[i]%2!=0) sb.append((char)(i+65));
            }
            // 마지막에 문자열을 반대로 더해주면 된다.
            for (int i = alphabet.length-1; i >= 0; i--) {
                for (int j = 0; j < alphabet[i]/2; j++) {
                    sb.append((char)(i+65));
                }
            }
       }
        System.out.println(sb);
    }
}
