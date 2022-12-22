package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        while(n != null){
            int num = Integer.parseInt(n);
            int tmp = 0;
            for (int i = 1; ; i++) {
                tmp = (tmp*10 + 1) % num;
                if(tmp == 0){
                    System.out.println(i);
                    break;
                }
            }
            n = br.readLine();
        }
    }
}
