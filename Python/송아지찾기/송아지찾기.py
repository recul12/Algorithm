import sys
from collections import deque
# 송아지 찾기
# 위치추적기가 달려있는 송아지를 잃어버렸다.
# 현수의 위치와 송아지의 위치가 직선상 좌표 점으로 주어진다면,
# 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
# 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
# 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하라.

sys.stdin=open("input7.txt","r")
MAX=10000
ch=[0]*(MAX+1)
dis=[0]*(MAX+1)
n,m = map(int, input().split())
ch[n]=1
dis[n]=0
dQ=deque()
dQ.append(n)
while dQ:
    now=dQ.popleft()
    if now==m:
        break
    for next in (now-1, now+1, now+5):
        if 0<next<=MAX:
            if ch[next]==0:
                dQ.append(next)
                ch[next]=1
                dis[next]=dis[now]+1

print(dis[m])