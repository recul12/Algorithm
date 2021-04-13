import sys

# 수열 추측하기
# 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다.
# 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
# N과 가장 밑 숫자가 주어졌을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
# 단 답이 여러가지일 경우 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

sys.stdin=open("input9.txt","r")

def DFS(depth, sum):
    if depth==n and sum==f:
        for x in p:
            print(x, end=' ')
        sys.exit(0)
    else:
        for i in range(1, n+1):
            if ch[i]==0:
                ch[i]=1
                p[depth]=i
                DFS(depth+1, sum+(p[depth]*b[depth]))
                ch[i]=0

if __name__ == "__main__":
    n, f=map(int, input().split())
    p=[0]*n
    b=[1]*n
    ch=[0]*(n+1)
    for i in range(1, n):
        b[i]=b[i-1]*(n-i)//i
    DFS(0, 0)