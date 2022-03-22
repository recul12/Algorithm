package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int K,N;
    static long max;
    public static void main(String[] args) throws IOException {
        // 랜선을 잘라 N개의 랜선을 만들자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        // 1<=K<=10,000 , 1<=N<=1,000,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        // K개의 랜선
        int cable[] = new int[K];
        // 랜선 최대 길이
        max=0;

        for (int i = 0; i < K; i++) {
            cable[i]=Integer.parseInt(br.readLine());
            max=Math.max(max,cable[i]);
        }

        // 랜선을 자르자
        System.out.println(cutLanCable(1,max,cable));
    }

    private static long cutLanCable(long lt, long rt, int cable[]) {

        while(lt<=rt){
            long mid=(lt+rt)/2;

            long count=0;

            for(int i=0; i< cable.length; i++){
                count+=cable[i]/mid;
            }
            if(count>=N){
                max=mid;
                lt=mid+1;
            }else{
                rt=mid-1;
            }

         }
        return max;
    }
}
