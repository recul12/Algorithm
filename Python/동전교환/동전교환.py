import sys

# 동전교환
# 여러 단위의 동전이 주어져 있을 때 거스름돈을 가장 적은 수의 동전으로 교환해주려면?
# 각 단위의 동전은 무한정 쓸 수 있다.

sys.stdin=open("input7.txt","r")

def DFS(depth,tsum):
    global result
    if result<=depth:
        return
    if m<tsum:
        return
    if m==tsum:
        if depth<result:
            result=depth
    else:
        for i in range(n-1,-1,-1):
            DFS(depth+1,tsum+coinList[i])


if __name__=="__main__":
    n=int(input())
    coinList=list(map(int,input().split()))
    m=int(input())

    result=2100000
    DFS(0,0)
    print(result)