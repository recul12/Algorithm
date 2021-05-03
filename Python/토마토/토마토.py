import sys
from collections import deque

# 토마토
# 현수의 토마토 농장에서는 토마토를 보관하는 창고를 갖고있다.
# 토마토 상자는 가로 M, 세로 N 의 칸 수를 가지고 있다.
# 토마토 중에는 잘 익은 것도 있지만, 아직 익지 않은 것들도 존재한다.
# 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은
# 익은 토마토의 영향을 받아 익게 된다.
# 하나의 토마토의 인접한 곳은 상하좌우 네 방향에 있는 토마토를 의미한다.
# 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로
# 익는 경우는 없다고 가정한다.
# 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶다.
# 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의
# 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는
# 프로그램을 작성하라. 단, 상자의 일부에는 토마토가 들어있지 않을 수 있다.
# 정수 1은 익은 토마토, 0은 익지 않은 토마토, -1은 들어있지 않다.

sys.stdin=open("input16.txt","r")

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

m, n=map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
dis=[[0]*m for _ in range(n)]
Q=deque()

for i in range(n):
    for j in range(m):
        if board[i][j]==1:
            Q.append((i,j))

while Q:
    tmp=Q.popleft()
    for j in range(4):
        x=tmp[0]+dx[j]
        y=tmp[1]+dy[j]
        if 0<=x<n and 0<=y<m and board[x][y]==0 :
            board[x][y]=1
            dis[x][y]=dis[tmp[0]][tmp[1]]+1
            Q.append((x,y))

flag=1
for i in range(n):
    for j in range(m):
        if board[i][j]==0:
            flag=0
result=0
if flag==1:
    for i in range(n):
        for j in range(m):
            if dis[i][j]>result:
                result=dis[i][j]
    print(result)
else:
    print(-1)