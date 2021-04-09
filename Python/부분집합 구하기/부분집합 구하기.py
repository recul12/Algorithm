import sys

# 부분집합 구하기
# 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하라

sys.stdin=open("input3.txt","r")

n=int(input())

cnt=[False]*n

def DFS(n,depth):
    if n==depth:
        for i in range(1,n+1):
            if cnt[i-1]:
                print(i,end=' ')
        print()
        return
    else:
        cnt[depth]=True
        DFS(n,depth+1)
        cnt[depth]=False
        DFS(n,depth+1)

DFS(n,0)
