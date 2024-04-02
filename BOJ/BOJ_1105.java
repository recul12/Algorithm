package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
    /*
        L과 R이 주어진다.
        이 때, L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에
        들어있는 8의 개수를 구하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        int result=0;

        // 자리수가 다른 경우
        if(L.length() != R.length()){
            System.out.println("0");
        }else{
            for (int i = 0; i < L.length(); i++) {
                // 두 숫자가 동일한 경우 8이면 추가한다.
                // 달라질 경우에는 더 이상 구할 필요가 없다.
                if(L.charAt(i) == R.charAt(i)){
                    if(L.charAt(i)=='8') result++;
                }else{
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
