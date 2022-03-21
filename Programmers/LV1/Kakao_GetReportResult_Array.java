import java.util.*;
public class Kakao_GetReportResult_Array {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer=new int[id_list.length];

        // 사람 x 사람 배열로 카운트를 세자
        int[][] count = new int[id_list.length][id_list.length];
        // 신고자 카운트 ㄱㄱ
        for(String x : report){
            StringTokenizer st = new StringTokenizer(x," ");

            // 첫 번째 토큰은 신고자, 두번째 토큰은 피신고자
            // 신고자 토큰을 저장
            String reporter=st.nextToken();
            int cnt=0;
            for(int i=0;i<id_list.length; i++){
                if(reporter.equals(id_list[i])) cnt=i;
            }
            // 두 번째 토큰
            String token=st.nextToken();
            // 신고자 중복 확인
            for(int i=0; i<id_list.length; i++){
                // 신고하면 그 사람의 카운트가 올라간다.
                if(token.equals(id_list[i])) {
                    count[cnt][i]++;
                }
            }
        }

        for(int i=0; i<count.length;i++){
            int tmp=0;
            for(int j=0; j< count[i].length; j++){
                if(count[j][i]!=0) tmp++;
            }
            if(tmp>=k)
                for(int j=0; j< count[i].length; j++){
                    if(count[j][i]!=0) answer[j]++;
                }
        }

        return answer;
    }
}