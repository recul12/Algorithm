package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        /*
            크로아티아 알파벳을 구한다.
            알파벳 소문자와 -, = 로만 이루어진 문자열이 주어진다.
            특정 문자가 오면 뒤에 오는 문자를 검사하는 식으로 풀어보자.
         */
        int sum=0; // 크로아티아 알파벳 개수
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // d일 경우에는 dz=라는 3글자를 고려해야한다
            if(c == 'd'){
                if(i < s.length()-1){ // i가 문자열의 길이 내에 있어야 뒷 문자를 검사가능하다.
                    // dz=를 위해 z를 검사하자.
                    if(s.charAt(i+1) == 'z' && i < s.length() -2 && s.charAt(i+2) == '='){
                        i+=2; // 문자만큼 건너뛰어서 다음 문자를 검사하자.
                    }
                    // d-인 경우를 확인하자.
                    else if(s.charAt(i+1) == '-'){
                        i++;
                    }
                }
            }
            // c,s,z는 뒷 문자가 =이면 크로아티아 알파벳이다.
            // c의 경우에는 뒷 문자가 -이면 크로아티아 알파벳이다.
            else if(c=='c' || c=='s' || c=='z'){
                if(i < s.length()-1) {
                    if (s.charAt(i + 1) == '=') {
                        i++;
                    }else if(c == 'c' && s.charAt(i+1)== '-')
                        i++;
                }
            }
            // l과 n 뒷 문자가 j면 크로아티아 알파벳이다.
            else if(c=='l' || c=='n'){
                if(i < s.length()-1) {
                    if (s.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }

            sum++;
        }
        System.out.println(sum);
    }
}
