package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2108_Counting_Sort {
    // Counting 정렬 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 정수들을 이용하여 통계값을 구하라.
        // 구해야하는 값은 산술평균, 중앙값, 최빈값, 범위
        // 입력되는 정수의 절댓값은 4000을 넘지 않는다.
        // 입력되는 정수들의 개수는 홀수다.

        // 정수의 개수
        int N = Integer.parseInt(br.readLine());
        /*
            구해야 하는 변수들
            산술 평균을 구하기 위한 sum
            오름차순 정렬을 했을 경우 중앙에 위치하는 중앙값 median
            가장 빈번하게 나타나는 최빈값(여러개일 경우 두번째로 작은 값) frequentValue
            범위를 구하기 위한 최대값과 최소값 max, min
         */
        int sum = 0;
        int median = 9999; // -4000~4000 안 값을 제외한 값으로 초기화
        int frequentValue = 9999;
        int max = Integer.MIN_VALUE; // 최소값으로 초기화
        int min = Integer.MAX_VALUE; // 최대값으로 초기화

        /*
            값을 가져오면서 다음과 같은 것들을 구한다.
            들어오는 모든 값을 합해 sum을 구한다.
            Counting Sort를 위한 배열을 하나 만들어서 수의 개수를 저장한다.
            최대값, 최소값을 구한다.
         */
        int arr[]=new int[8001];//입력 가능한 정수만큼의 크기
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            sum+=input;
            arr[input+4000]++;
            if(max<input) max=input;
            if(min>input) min=input;
        }

        /*
            구한 최대값과 최소값 사이의 숫자만큼만으로 범위를 좁힐 수 있다.
            N이 홀수이므로, 중앙값은 (N+1)/2의 위치에 있게 될 것이다.
            카운팅 정렬을 위한 배열에서 숫자를 세어 (N+1)/2 번째의 숫자가 중앙값이 된다.
            이 중앙값을 구하기 위해 배열 내의 숫자들을 더해줄 변수 하나를 추가하여 (N+1)/2번째의 숫자를 구한다.
            이 배열은 이미 정돈된 상태이므로, 순서대로 배열 내의 숫자가 큰 것을 정하고 만약 중복된다면
            두번째로 작은 값을 찾아야하므로 한 번만 중복되는 값이 두번째로 작은 값이 되는 최빈값이 된다.
         */
        // 중앙값을 위한 변수
        int count = 0; // 누적수
        // 최빈값을 위한 변수
        int numberOfFrequentValue=0; // 최빈값의 개수
        boolean flag = false; // 중복값을 확인하기 위한 flag

        for (int i = min+4000; i <= max+4000; i++) {
            if(arr[i]>0){
                // 중앙값 구하기
                if(count < (N+1)/2){
                    count += arr[i];
                    median = i-4000;
                }
                // 최빈값 구하기
                if(numberOfFrequentValue < arr[i]){
                    numberOfFrequentValue = arr[i];
                    frequentValue = i-4000;
                    flag=true;
                }
                // 중복되는 값이 존재하면 두번째로 작은 값을 최빈값으로 출력
                else if(numberOfFrequentValue == arr[i] && flag){
                    frequentValue = i-4000;
                    flag=false;
                }
            }
        }

        /*
            산술평균 구하기
            N개의 수들의 합을 N으로 나눈 값을 구하라.
            소수점 이하 첫째 자리에서 반올림한 값을 출력해야 한다.
            Math.round 로 소수점 이하 첫째 자리에서 반올림한 값을 구할 수 있다.
         */
        System.out.println((int)Math.round((float)sum/N));
        /*
            중앙값 구하기
            N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값 출력
            for문에서 구한 median 값이 중앙값
         */
        System.out.println(median);
        /*
            최빈값 구하기
            N개의 수들 중 가장 많이 나타나는 값을 출력
            여러개 존재할 경우 두번째로 작은 값을 출력
            위의 for 문에서 구한 frequentValue 가 최빈값
         */
        System.out.println(frequentValue);
        /*
            범위 구하기
            max-min 출력
         */
        System.out.println(max-min);
    }
}
