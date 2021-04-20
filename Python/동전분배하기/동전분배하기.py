import sys

# 동전 분배하기
# N개의 동전을 세사람에게 나누어 주려고 한다.
# 세 명에게 적절히 나누어 주어서 세 명이 받은 각 총액을 계산해서 가장 큰 사람과
# 가장 작은 사람의 차가 최소가 되도록 하라.
# 단 세 사람의 총액은 서로 달라야한다.

sys.stdin=open("input5.txt","r")

def DFS(depth):
    global res
    if depth==n:
        m=max(s)-min(s)
        if m<res:
            tmp=set()
            for x in s:
                tmp.add(x)
            if len(tmp)==3:
                res=m
    else:
        for i in range(3):
            s[i]+=a[depth]
            DFS(depth+1)
            s[i]-=a[depth]

if __name__=="__main__":
    n=int(input())
    a=list(int(input()) for _ in range(n))
    s=[0,0,0]
    res=2147000000
    DFS(0)
    print(res)