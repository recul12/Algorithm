import sys

# 돌다리 건너기(Bottomup)
# 철수는 학교에 가는데 개울을 만났다
# 개울은 N개의 돌로 다리를 이루고 있다.
# 철수는 돌다리를 건널 때 한번에 한 칸, 두칸씩 건너뛰면서 다리를 건널 수 있다.
# 철수가 개울을 건너는 방법은 몇 가지인가

sys.stdin=open("input4.txt","r")

n=int(input())
dy=[0]*(n+1)
dy[0]=1
dy[1]=2
for i in range(2, n+1):
    dy[i]=dy[i-1]+dy[i-2]

print(dy[n])