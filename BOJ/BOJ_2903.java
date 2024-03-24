package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2903 {
    /*
        상근이의 앞에 꼭지점 4개에 큰 점이 있는 정사각형이 있다.
        정사각형은 다음과 같은 알고리즘으로 변형된다.
            1. 정사각형의 각 변의 중앙에 점을 하나 추가한다.
            2. 정사각형의 중심에 점을 하나 추가한다.
        이러면 총 4개의 정사각형이 새로 생긴다.
        이런 식으로 계속해서 원하는 시점까지 정사각형을 만든다.
        그러다가 어떤 점은 한 개 보다 많은 정사각형에 포함될 수 있다는 것을 알았다.
        메모리를 최소화하기 위해서 중복점을 한 개만 저장하려고 한다면 과정을 N번 거친 후 점 몇개를 저장해야하는가?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 변마다 2, 3, 5, 9 이런 식으로 늘어나고 점의 개수는 각 변의 제곱과 같다.
        // 증가치는 1, 2, 4, 8 식으로 2의 제곱으로 늘어나고 N=1 결과가 9이므로 첫번째가 3이 되도록 1을 더하면 된다.
        System.out.println((int)Math.pow(Math.pow(2, N)+1, 2));
    }
}
