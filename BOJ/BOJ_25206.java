package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206 {
    /*
        한 학생이 인하대 컴퓨터공학과를 졸업하기 위해서 전공평점 3.3 혹은 졸업고사를 통과해야한다.
        그러나 졸업고사를 응시하는 것을 잊어버렸다.
        학생이 무사히 졸업할 수 있을지 전공 평점을 계산해보자.
        전공평점은 전공과목별 학점x과목평점 의 합을 학점의 총합으로 나눈 값이다.
        Pass or Fail인 과목은 P인 경우를 제외한다.

        몇 가지 제한사항이 있다.
        1. 1 ≤ 과목명의 길이 ≤ 50
        2. 과목명은 알파벳 대소문자 또는 숫자로만 이루어져 있으며, 띄어쓰기 없이 주어진다. 입력으로 주어지는 모든 과목명은 서로 다르다.
        3. 학점은 1.0,2.0,3.0,4.0중 하나이다.
        4. 등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
        5. 적어도 한 과목은 등급이 P가 아님이 보장된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] credit = new double[20];
        String[] grade = new String[20];
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 계산에 전공과목이름은 필요가 없으니 빼준다.
            st.nextToken();
            // 이수학점과 등급만 배열에 빼둔다.
            credit[i]=Double.parseDouble(st.nextToken());
            grade[i]=st.nextToken();
        }

        double sum=0;
        double creditSum = 0;
        for (int i = 0; i < 20; i++) {
            double gradeToDouble = grade(grade[i]);
            if(gradeToDouble == -1) continue;
            sum+=gradeToDouble*credit[i];
            creditSum += credit[i];
        }

        System.out.println(sum/creditSum);
    }

    private static double grade(String s){
        double result = 0;
        switch (s){
            case "A+":
                result=4.5;
                break;
            case "A0":
                result=4.0;
                break;
            case "B+":
                result=3.5;
                break;
            case "B0":
                result=3.0;
                break;
            case "C+":
                result=2.5;
                break;
            case "C0":
                result=2.0;
                break;
            case "D+":
                result=1.5;
                break;
            case "D0":
                result=1.0;
                break;
            case "F":
                result=0.0;
                break;
            default:
                result=-1;
                break;
        }
        return result;
    }
}
