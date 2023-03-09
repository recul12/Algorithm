package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
            다솜이의 기타들이 가지고 있는 시리얼 번호를 정렬한다.
            기타의 개수 N이 주어진다.
            모든 시리얼 번호는 알파벳 대문자와 숫자로 이루어져있다.
            시리얼번호 A가 B의 앞에 오는 경우는 다음과 같다.
            1. 짧은 것이 먼저 온다.
            2. 길이가 같으면 모든 자리수의 합을 비교하여 작은 합을 가지는 것이 먼저 온다(숫자만비교)
            3. 1,2 조건으로 비교 불가능하면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
         */
        // 기타 개수
        int N = Integer.parseInt(br.readLine());

        // 시리얼 번호 저장
        ArrayList<String[]> list = new ArrayList<>();
        // 시리얼 번호, 길이, 숫자합 세가지를 저장한다.

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(new String[2]);
            list.get(i)[0]=s;

            // 숫자합 구하기
            int sum=0;
            for(char c : s.toCharArray()) {
                if(Character.isDigit(c)) {
                    sum += Character.getNumericValue(c);
                }
            }
            list.get(i)[1]=String.valueOf(sum);
        }


        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].length()!=o2[0].length())
                    return o1[0].length() - o2[0].length();
                else{
                    if(Integer.parseInt(o1[1])!=Integer.parseInt(o2[1]))
                        return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                    else {

                        return o1[0].compareTo(o2[0]);
                    }
                }
            }
        };


        Collections.sort(list,comparator);

        for(String[] s : list) {
            System.out.println(s[0]);
        }
    }
}
