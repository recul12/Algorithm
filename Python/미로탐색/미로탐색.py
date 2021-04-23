import sys

# 미로탐색
# 7*7 격자판 미로를 탈출하는 가짓수를 출력하는 프로그램 작성
# 출발점은 격자의 (1,1) 좌표이고 탈출 도착점은 (7,7) 좌표이다.
# 격자판의 1은 벽이고, 0은 도로이다.
# 격자판은 상하좌우로만 움직인다.
# 경로의 가짓수를 구하시오.

sys.stdin=open("input10.txt","r")

def DFS(depthx,depthy):
    global cnt
    if depthx==6 and depthy==6:
        cnt+=1
    else:
        for i in range(4):
            x = depthx + dx[i]
            y = depthy + dy[i]
            if 0 <= x <= 6 and 0 <= y <= 6 and n[x][y]==0:
                n[x][y]=1
                DFS(x,y)
                n[x][y]=0


if __name__=="__main__":
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    n=[list(map(int,input().split())) for _ in range(7)]
    cnt=0
    n[0][0]=1
    DFS(0,0)
    print(cnt)