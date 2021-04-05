import sys
from collections import deque

# 응급실
# 응급실은 환자가 도착한 순서대로 진료
# 하지만 위험도가 높은 환자는 빨리 응급조치 해야함
# 이를 위해 응급실은 진료순서를 정했다.
# 1. 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼낸다.
# 2. 나머지 대기 목록에서 꺼낸 환자보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로
# 다시 넣는다. 그렇지 않으면 진료를 받는다.

sys.stdin=open("input6.txt","r")

n,m=map(int,input().split())
dp=list(map(int,input().split()))

dp=deque(dp)


cnt=0
while dp:
    mx=max(dp)
    tmp=dp.popleft()
    if tmp<mx:
        dp.append(tmp)
        m=(m-1)%n
    else:
        m-=1
        n-=1
        cnt+=1
        if m==-1:
            break

print(cnt)