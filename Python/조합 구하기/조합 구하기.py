import sys

# 조합 구하기

sys.stdin=open("input10.txt","r")

def DFS(depth,tmp,x):
    global cnt
    if depth==m:
        for c in tmp:
            print(c,end=' ')
        print()
        cnt+=1
    else:
        for i in range(x,n+1):
            tmp[depth]=i
            DFS(depth+1,tmp,x+1)
            x+=1


if __name__ == "__main__":
    n,m=map(int,input().split())
    tmp=[0]*m
    cnt=0
    DFS(0,tmp,1)
    print(cnt)

