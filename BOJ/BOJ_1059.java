package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1059 {
    /*
        정수 집합 S 가 주어지고, 아래의 특정 조건을 만족하는 구간 [A,B]를 좋은 구간이라 한다.
        1. A,B는 양의 정수이고, A<B를 만족한다.
        2. A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.
        집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
            다음과 같은 제한사항이 있다.
            1. 1 ≤ L ≤ 50
            2. 집합 S에는 중복되는 정수가 없다.
            3. 집합 S에 있는 모든 정수는 1보다 크거나 같고 1000보다 작거나 같다.
            4. 1 ≤ n ≤ S에서 가장 큰 정수
         */
        int L = Integer.parseInt(br.readLine());
        int S[] = new int[L];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i]=Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        //좋은 구간 개수
        int count = 0;
        // 배열을 정렬해준다
        Arrays.sort(S);

        // 집합 S에서 n보다 큰 정수를 저장한다.
        int store = 0;
        int idx = 0;
        for (int i = 0; i < S.length; i++) {
            if(S[i] == n) break;
            if(S[i] > n) {
                store = S[i];
                idx = i;
                break;
            }
        }

        if(store == 0) System.out.println(count);
        else {
            if(store == S[0]){
                for (int i = 1; i <= n; i++) {
                    // 1부터 n을 포함한 끝까지의 구간을 모두 구한다
                    // 좋은 구간은 결국 n을 포함하는 구간을 S[x]와 S[x+1] 사이에서 만드는것
                    // 구간은 n을 포함하여 더 큰수 S[x+1]보다 1작은 수까지 구하는 것
                    // 더 작은 수보다 1 큰 수(i) 부터 n까지 순차대로 n까지의 구간을 만들어준다.
                    // [1,n]이 만들어진다.
                    // 이후 [1,n+1]..[1,S[x+1]-1] 까지 구간이 구해진다.
                    // 계산은 결국 n부터 S[x+1]-1 까지의 개수를 구하는 것이다.
                    // 즉 S[x+1]-1 - n + 1 = S[x+1] - n
                    // 여기서 마지막 n부분은 [n,n+1]부터 시작하므로 1이 적어야한다.
                    count+=S[0]-n;
                    if(i == n) count--;
                }
            }else{
                for (int i = S[idx-1]+1; i <= n; i++) {
                    count+=S[idx]-n;
                    if(i == n) count--;
                }
            }
            System.out.println(count);
        }

    }
}
