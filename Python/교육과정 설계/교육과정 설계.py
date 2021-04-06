import sys
from collections import deque
# 교육과정 설계
# 수업 중엔 필수과목이 존재, 순서도 정해져 있다.
# 총 과목이 A,B,C,D,E,F,G 가 있고, 필수과목이 CBA 면 필수과목은 C, B, A 순서로 계획이 짜여져야한다.
# 즉 B는 C 이후, A는 C,B 모두 이수한 후에 들어야한다.
# 각 과목이 무조건 이수된다고가정 할 때 현수가 짠 N개의 수업설계가 잘 된것이면 YES,
# 잘못된 것이면 NO를 출력하라.

sys.stdin=open("input7.txt","r")

need=input()
n=int(input())

for i in range(n):
    plan=input()
    dq=deque(need)
    for x in plan:
        if x in dq:
            if x!=dq.popleft():
                print("#%d NO"%(i+1))
                break
    else:
        if len(dq)==0:
            print("#%d YES"%(i+1))
        else:
            print("#%d NO"%(i+1))