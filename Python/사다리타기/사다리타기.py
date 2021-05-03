import sys

# 사다리 타기
# 현수와 친구들은 과자를 사먹기 위해 사다리 타기를 하기로 한다.
# 사다리 표현은 2차원 평면으로 사다리는 1로 채워진다. 사다리가 아닌 곳은 0이다.
# 현수는 특정 도착지점으로 도착하기 위해서는 몇번째 열에서 출발해야 하는지 알고 싶어한다.
# 특정 지점이 2로 표시 될 때, 어디에서 출발해야하는지 구하시오.

sys.stdin=open("input17.txt","r")

def DFS(x,y):
    ch[x][y]=1
    if x==0:
        print(y)
    else:
        if  y<9 and ladder[x][y+1]==1 and ch[x][y+1]==0:
            DFS(x, y + 1)
        elif y>0 and ladder[x][y-1]==1 and ch[x][y-1]==0:
            DFS(x, y - 1)
        else:
            DFS(x-1,y)



if __name__=="__main__":
    ladder=[list(map(int,input().split())) for _ in range(10)]
    ch=[[0]*10 for _ in range(10)]
    for y in range(10):
        if ladder[9][y]==2:
            DFS(9,y)

