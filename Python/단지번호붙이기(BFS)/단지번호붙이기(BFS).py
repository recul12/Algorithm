import sys
from collections import deque
# 단지 번호 붙이기(BFS)
# 정사각형 모양의 지도가 있다.
# 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
# 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
# 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래 위로 다른 집이 있는 경우를 말한다.
# 대각선상에 집이 있는 경우는 연결된 것이 아니다.
# 그림 2는 그림 1을 단지별로 번호를 붙인 것이다. 지도를 입력해 단지수를 출력하고
# 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하라.


sys.stdin=open("input13.txt","r")

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n=int(input())
board=[list(map(int,input())) for _ in range(n)]
Q=deque()
res=[]
cnt=0
for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            Q.append((i,j))
            board[i][j] = 0
            cnt = 1
            while Q:
                tmp=Q.popleft()
                for k in range(4):
                    x=tmp[0]+dx[k]
                    y=tmp[1]+dy[k]
                    if 0<=x<n and 0<=y<n and board[x][y]==1:
                        board[x][y]=0
                        cnt+=1
                        Q.append((x,y))
            res.append(cnt)
print(len(res))
res.sort()
for x in res:
    print(x)



