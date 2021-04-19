import sys

# 동전 바꿔주기
# 명보네 동네 가게 현금 출납기에는 K가지 동전이 각각 n1,n2,....,nk개 씩 들어있다.
# 가게 주인은 명보에게 T원의 지폐를 동전으로 바꿔주려고 한다.
# 이 때, 동전 교환 방법은 여러가지가 있을 수 있다.
# 예를 들어, 10원, 5원, 1원짜리 동전이 각각 2, 3, 5 개씩 있을 때,
# 20원 짜리 지폐를 다음과 같은 4가지 방법으로 교환할 수 있다.
# 20=10x2, 20= 10x1+5x2, 20=10x1+5x1+1x5, 20=5x3+1x5
# 입력으로 지폐 금액 T, 동전 가지수 k, 각 동전 하나의 금액 pi와 개수 ni 가 주어질 때
# i(=1,2,...,k)
# 지폐를 동전으로 교환하는 방법의 가지 수를 계산하는 프로그램을 작성하시오. 방법의 수는 2^31
# 을 초과하지 않는 것으로 가정한다.

sys.stdin=open("input4.txt","r")

def DFS(depth,sum):
    global cnt
    if sum>T:
        return
    if depth==k:
        if sum==T:
            cnt+=1
    else:
        for i in range(nList[depth]+1):
            DFS(depth+1,sum+(pList[depth]*i))

if __name__=="__main__":
    T=int(input())
    k=int(input())
    pList=list()
    nList=list()
    cnt=0
    for i in range(k):
        a, b=map(int,input().split())
        pList.append(a)
        nList.append(b)
    DFS(0,0)
    print(cnt)

