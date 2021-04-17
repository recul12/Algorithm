import sys
# 최대점수 구하기
# 현수는 N개의 문제를 풀려고 한다.
# 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어진다.
# 제한시간 M 안에 N 개의 문제 중 최대점수를 얻을 수 있도록 해야한다.
# 해당문제는 해당시간이 걸리면 푸는 걸로 간주한다. 한 유형당 한 개만 풀 수 있다.

sys.stdin=open("input.txt","r")
def DFS(depth, t, s):
    global res
    if t>m:
        return
    if depth==n:
        if s>res:
            res=s
    else:
        DFS(depth+1,t+time[depth],s+score[depth])
        DFS(depth+1,t,s)


if __name__=="__main__":
    n,m=map(int,input().split())
    time=list()
    score=list()
    for i in range(n):
        a,b=map(int,input().split())
        score.append(a)
        time.append(b)
    res=0
    DFS(0,0,0)
    print(res)