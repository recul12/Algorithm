package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    static int N, M;
    static int[] request;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int lt=0,rt=0;
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        request=new int[N];
        for (int i = 0; i < N; i++) {
            request[i]=Integer.parseInt(st.nextToken());
            rt=Math.max(rt, request[i]);
        }
        M=Integer.parseInt(br.readLine());

        // 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
        // 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
        // 상한액 이하의 예산요청에 대해서는 요청한 금액 그대로 배정한다.
        // 상한액이 나올 때까지 이분 탐색을 돌린다.
        while(lt<=rt){
            int mid=(lt+rt)/2;
            long budget = 0;
            for (int i = 0; i < N; i++) {
                if(request[i] > mid) budget+=mid;
                else budget+=request[i];
            }
            if(budget <= M) lt=mid+1;
            else rt=mid-1;
        }
        System.out.println(rt);
    }
}
