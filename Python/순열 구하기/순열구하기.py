import sys

# 순열 구하기
# 1부터 N까지 번호가 적힌 구슬 중 M개 뽑아 일렬로 나열하는 방법을 모두 구하라

sys.stdin=open("input8.txt","r")

def DFS(L):
    global cnt
    if L==m:
        for i in range(m):
            print(res[i], end=' ')
        print()
        cnt+=1
    else:
        for i in range(1, n+1):
            if ch[i]==0:
                ch[i]=1
                res[L]=i
                DFS(L+1)
                ch[i]=0

if __name__=="__main__":
    n, m=map(int, input().split())
    res=[0]*n
    ch=[0]*(n+1)
    cnt=0
    DFS(0)
    print(cnt)
