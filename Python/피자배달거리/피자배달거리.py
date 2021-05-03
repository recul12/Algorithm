import sys

# 피자 배달 거리
# NxN 크기의 도시 지도가 있다.
# 도시 지도는 1x1 크기의 격자칸으로 이루어져있고
# 각 격자칸은 0이 빈 칸, 1은 집, 2는 피자집으로 표현된다.
# 각 격자칸은 좌표(행, 열)로 표현되고 행은 1 부터 N, 열도 1부터 N까지이다.
# 도시에는 각 집마다 피자배달거리가 있는데 각 집의 피자배달거리는 해당 집과 도시에
# 존재하는 피자집들간의 거리 중 최소값을 해당 집의 피자배달거리라고 한다.
# 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2|이다.
# 시장이 너무 많은 피자집을 줄이려 M 개의 피자집만 살리려고 한다면
# M개를 선택하는 기준은 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 한다.
# 도시의 피자배달거리는 각 집들의 피자배달거리를 합한 것을 말한다.

sys.stdin=open("input18.txt","r")

def DFS(L,s):
    global res
    # L이 m개(조합이 뽑혔을 때까지)일 때 까지 돈다.
    if L==m:
        sum=0
        for j in range(len(hs)):
            x1=hs[j][0]
            y1=hs[j][1]
            dis=2147000000
            for x in cb:
                x2=pz[x][0]
                y2=pz[x][1]
                dis = min(dis, abs(x1 - x2) + abs(y1 - y2))
            sum+=dis
        if res>sum:
            res=sum
    else:
        # 피자집 개수에서 선택될 m개의 조합을 뽑아 재귀를 돌린다.
        for i in range(s,len(pz)):
            cb[L]=i
            DFS(L+1,i+1)


if __name__=="__main__":
    # 집 배열, 피자집 배열
    hs=[]
    pz=[]
    # n, m 불러오기
    n,m=map(int,input().split())
    # 결과값 res
    res=2147000000
    # 조합 저장 행렬 cb
    cb=[0]*m
    # nxn 행렬
    board=[list(map(int,input().split())) for _ in range(n)]
    # 집과 피자집의 좌표를 hs, pz 배열에 저장
    for i in range(n):
        for j in range(n):
            if board[i][j]==1:
                hs.append((i,j))
            elif board[i][j]==2:
                pz.append((i,j))

    DFS(0,0)
    print(res)


