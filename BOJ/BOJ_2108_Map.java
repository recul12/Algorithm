package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108_Map {
    // Map 이용하여 최빈값 구하기
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
        int median = 0;
        int frequentValue = 0;
        int max = Integer.MIN_VALUE; // 최소값으로 초기화
        int min = Integer.MAX_VALUE; // 최대값으로 초기화
        /*
            값을 가져오면서 다음과 같은 것들을 구한다.
            들어오는 모든 값을 합해 sum을 구한다.
            배열을 하나 만들어서 수를 저장한다.
            수의 개수를 저장하기 위해 HashMap을 만들어 key를 수, value를 수의 개수로 저장한다.
            최대값, 최소값을 구한다.
         */
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // 배열을 오름차순으로 정렬한다.
        Arrays.sort(arr);
        // 배열의 오른쪽 끝값이 최대값, 0번째 값이 최소값이 된다.
        max=arr[N-1];
        min=arr[0];
        /*
            산술평균은 위에서 구한 sum값과 Math.round를 이용하여 구할 수 있다.
            중앙값은 정렬한 배열의 가운데의 값인 arr[N/2]의 값으로 구할 수 있다.
            최빈값은 map에 있는 최대의 value 를 구하고 중복이 있다면 두번째로 작은 값을 구하면 된다.
            범위는 max-min 값으로 구할 수 있다.
         */
        // 산술평균
        int average = Math.round((float) sum/N);
        // 중앙값
        median = arr[N/2];
        // 최빈값
        // 최대의 value 값 찾기
        Integer maxValue = Collections.max(map.values());
        // key 중 maxValue와 같은 값 찾고, 그 값을 list에 저장
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxValue){
                arrayList.add(key);
            }
        }
        // list 정렬
        Collections.sort(arrayList);
        // 크기가 1보다 크면 중복이 있으므로 2번째 숫자, 아니라면 첫번째 숫자를 가져온다.
        if(arrayList.size()>1) frequentValue=arrayList.get(1);
        else frequentValue=arrayList.get(0);

        System.out.println(average);
        System.out.println(median);
        System.out.println(frequentValue);
        System.out.println(max-min);
    }
}
