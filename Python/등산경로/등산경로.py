import sys

# 등산경로
# 등산을 좋아하는 철수는 뒷산에 등산경로를 만드려고 한다.
# 마을 뒷산의 형태를 나타낸 지도는 N*N 구역으로 나뉘어져 있다.
# 각 구역에는 높이가 함께 나타나 있다.
# N=5이면 다음과 같이 표현된다.
# 2 23 92 78 93
# 59 50 48 90 80
# 30 53 70 75 96
# 94 91 82 89 93
# 97 98 95 96 100
# 어떤 구역에서 다른 구역으로 등산을 할 때는 그 구역의 상하좌우중 더 높은 구역으로만
# 이동할 수 있도록 설계하고자 한다.
# 등산로의 출발지는 전체영역에서 가장 낮은곳이고 목적지는 가장 높은 곳이다.
# 출발지와 목적지는 유일하다.
# 지도가 주어지면 출발지에서 도착지로 갈 수 있는 등산 경로가 몇 가지인지 구하는
# 프로그램을 작성하시오.

sys.stdin=open("input11.txt","r")
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(depthx,depthy):
    global cnt
    if depthx==ex and depthy==ey:
        cnt+=1
    else:
        for k in range(4):
            x=depthx+dx[k]
            y=depthy+dy[k]
            if 0<=x<n and 0<=y<n and ch[x][y]==0 and board[depthx][depthy]<board[x][y]:
                ch[x][y]=1
                DFS(x,y)
                ch[x][y]=0

if __name__=="__main__":
    n=int(input())
    board=[list(map(int,input().split())) for _ in range(n)]
    ch=[[0]*n for _ in range(n)]
    cnt=0
    smallest=2147000000
    largest=-2147000000
    for i in range(n):
        for j in range(n):
            if board[i][j]<smallest:
                smallest=board[i][j]
                sx=i
                sy=j
            if board[i][j]>largest:
                largest=board[i][j]
                ex=i
                ey=j
    ch[sx][sy]=1
    DFS(sx,sy)
    print(cnt)