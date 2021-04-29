import sys
from collections import deque

# 안전영역
# 재난방재청에서는 많은 비가 내리는 장마철에 대비해 다음과 같은 일을 계획하고 있다.
# 먼저 어떤 지역의 높이 정보를 파악한다. 그 다음 그 지역에 많은 비가 내렸을 때
# 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어지는지 조사하려한다.
# 이 때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의
# 모든 지점은 물에 잠긴다고 가정한다.
# 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며
# 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
# 예를 들어, 다음은 N=5인 지역의 높이 정보이다.
# 6 8 2 6 2
# 3 2 3 4 6
# 6 7 3 3 2
# 7 2 5 3 6
# 8 9 5 2 7
# 물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 상하좌우로 인접
# 해 있으며 그 크기가 최대인 영역을 말한다.
# 예를 들어 높이가 4 이하인 모든 지점이 물에 잠긴다면 안전 영역은 5개이다.
# 어떤 지역에 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의
# 최대 개수를 구하시오.

sys.stdin=open("input15.txt","r")

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n=int(input())
board=[[0]*n for _ in range(n)]
Q=deque()
largest=0
for i in range(n):
    tmp=list(map(int,input().split()))
    for j in range(n):
        if tmp[j]>largest:
            largest=tmp[j]
        board[i][j]=tmp[j]

cntL=[]
for k in range(1,largest+1):
    ch = [[0] * n for _ in range(n)]
    cnt=0
    for i in range(n):
        for j in range(n):
            if board[i][j]>k and ch[i][j]==0:
                Q.append((i,j))
                ch[i][j]=1
                while Q:
                    tmp=Q.popleft()
                    for l in range(4):
                        x=tmp[0]+dx[l]
                        y=tmp[1]+dy[l]
                        if 0<=x<n and 0<=y<n and ch[x][y]==0 and board[x][y]>k:
                            ch[x][y]=1
                            Q.append((x,y))
                cnt+=1
    if cnt!=0:
        cntL.append(cnt)
print(max(cntL))