package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        char[] chars=br.readLine().toCharArray();

        int[] count=new int[10];
        int maxCount=0;
        for (char c: chars) {
            int tmp=c-'0';
            count[tmp]++;
            if(tmp==6 || tmp == 9) continue;
            maxCount=Math.max(count[tmp],maxCount);
        }
        int max69=0;
        if((count[6]+count[9])%2==1) max69=(count[6]+count[9])/2+1;
        else max69=(count[6]+count[9])/2;

        System.out.println(Math.max(maxCount,max69));
    }
}
