import sys
from collections import deque

# 사과나무(BFS)
# 기존 사과나무 문제를 BFS 방식으로 푸는것
# N*N 격자판에서 다이아몬드 모양의 격자판만 수확하여
# 사과의 총 개수를 구하는 문제

sys.stdin=open("input8.txt","r")

dx=[-1,0,1,0]
dy=[0,1,0,-1]
n=int(input())
nL=[list(map(int,input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
sum=0
Q=deque()
ch[n//2][n//2]=1
sum+=nL[n//2][n//2]
Q.append((n//2,n//2))
L=0
while True:
    if L==n//2:
        break
    size=len(Q)
    for i in range(size):
        tmp=Q.popleft()
        for j in range(4):
            x=tmp[0]+dx[j]
            y=tmp[1]+dy[j]
            if ch[x][y]==0:
                sum+=nL[x][y]
                ch[x][y]=1
                Q.append((x,y))
    L+=1

print(sum)
