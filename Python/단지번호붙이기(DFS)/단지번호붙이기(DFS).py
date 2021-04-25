import sys

# 단지 번호 붙이기(DFS)
# 정사각형 모양의 지도가 있다.
# 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
# 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
# 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래 위로 다른 집이 있는 경우를 말한다.
# 대각선상에 집이 있는 경우는 연결된 것이 아니다.
# 그림 2는 그림 1을 단지별로 번호를 붙인 것이다. 지도를 입력해 단지수를 출력하고
# 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하라.


sys.stdin=open("input12.txt","r")

def DFS(depthx,depthy):
    global num
    for k in range(4):
        x = depthx + dx[k]
        y = depthy + dy[k]
        if 0 <= x < n and 0 <= y < n and board[x][y]==1 and ch[x][y]==0:
                ch[x][y]=1
                num+=1
                DFS(x,y)


if __name__=="__main__":
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    n=int(input())
    board=[list(map(int,input())) for _ in range(n)]
    ch=[[0]*n for _ in range(n)]
    numL=[]
    for i in range(n):
        for j in range(n):
            if board[i][j]==1 and ch[i][j]==0:
                x=i
                y=j
                ch[i][j]=1
                num=1
                DFS(i,j)
                numL.append(num)
    print(len(numL))
    numL.sort()
    for x in numL:
        print(x)
