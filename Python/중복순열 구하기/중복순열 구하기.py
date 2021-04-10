import sys

# 중복순열 구하기
# 1부터 N까지 구슬 중 중복을 허락하여 M 번을 뽑아 일렬로 나열하는 방법 출력

sys.stdin=open("input6.txt","r")

def DFS(depth,tmp):
    global result
    if depth==m:
        for j in range(depth):
            print(tmp[j],end=" ")
        print()
        result+=1
    else:
        for i in range(1,n+1):
            tmp[depth]=i
            DFS(depth+1,tmp)

if __name__=="__main__":
    n,m=map(int,input().split())
    tmp=[0]*m
    result=0
    DFS(0,tmp)
    print(result)
