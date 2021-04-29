import sys
from collections import deque

# 섬나라 아일랜드
# 섬나라 아일랜드 지도가 격자판의 정보로 주어진다.
# 각 섬은 1로 표시되어 상하좌우, 대각선으로 연결되어 있으며, 0은 바다이다.
# 섬나라 아일랜드에는 몇 개의 섬이 있는지 구하라.

sys.stdin=open("input14.txt","r")

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

n=int(input())
board=[list(map(int,input().split())) for _ in range(n)]
Q=deque()
cnt=0
for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            Q.append((i,j))
            board[i][j]=0
            while Q:
                tmp=Q.popleft()
                for k in range(8):
                    x=tmp[0]+dx[k]
                    y=tmp[1]+dy[k]
                    if 0<=x<n and 0<=y<n and board[x][y]==1:
                        board[x][y]=0
                        Q.append((x,y))
            cnt+=1
print(cnt)