import sys
from collections import deque

# 미로의 최단거리 통로
# 7*7 격자판 미로를 탈출하는 최단경로의 경로수를 출력하는 프로그램 작성
# 경로수는 출발점에서 도착점까지 가는데 이동한 횟수를 의미
# 출발점은 격자의 (1,1) 좌표이고 탈출 도착점은 (7,7) 좌표이다.
# 격자판의 1은 벽이고, 0은 도로이다.
# 최단경로를 구하시오

sys.stdin=open("input9.txt","r")

dx=[-1,0,1,0]
dy=[0,1,0,-1]

n=[list(map(int,input().split())) for _ in range(7)]
dis=[[0]*7 for _ in range(7)]
Q=deque()
Q.append((0,0))
n[0][0]=1
while Q:
    tmp=Q.popleft()
    for j in range(4):
        x=tmp[0]+dx[j]
        y=tmp[1]+dy[j]
        if 0<=x<=6 and 0<=y<=6 and n[x][y]==0:
            n[x][y]=1
            dis[x][y]=dis[tmp[0]][tmp[1]]+1
            Q.append((x,y))

if dis[6][6]==0:
    print(-1)
else:
    print(dis[6][6])

