package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    /**
     * 다단계 조건
     * 조건 1. 모든 판매원은 칫솔 판매 이익에서 10%를 계싼해서 조직에 참여시킨 추천인에게 배부한다.
     * 조건 2. 10%의 이익은 또 그 자신의 추천인에게 10% 분배된다.
     * 조건 3. 10%를 계산할 때에는 원 단위에서 절사하고, 10%를 계산한 금액이 1원 미만일땐 모두 자신이 가진다.
     */
    public static void main(String[] args) {
        다단계_칫솔_판매 T=new 다단계_칫솔_판매();
        /*
            1<=enroll<=10000, 1<=referral<=10000, 1<=seller<=100000, 1<=amount<=100000
         */
        String[] enroll={"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller={"young", "john", "tod", "emily", "mary"};
        int[] amount={12, 4, 2, 5, 10};

        T.solution(enroll,referral,seller,amount);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> persons = new HashMap<>();
        // map에 각 enroll의 추천인 넣기
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i],referral[i]);
            // 판매원들 인덱스
            persons.put(enroll[i], i);
        }
        // seller 보기
        for (int i = 0; i < seller.length; i++) {
            // 기본적인 칫솔 판매 계산
            // 칫솔 판매 개수 * 100
            int sales= amount[i]*100;
            answer[persons.get(seller[i])]+=sales-(int)(sales*0.1);
            // 추천인 확인을 위한 인덱스
            int person=persons.get(seller[i]);
            // 추천인에게 주는 금액
            int won = (int)(sales*0.1);
            // - 가 아니라면 다음 추천인에게 돈 주는 알고리즘
            while(!referral[person].equals("-")) {
                answer[persons.get(referral[person])]+=won-(int)(won*0.1);
                won=(int)(won*0.1);
                if(won<1) break;
                person=persons.get(referral[person]);
            }
        }

        return answer;
    }
}
