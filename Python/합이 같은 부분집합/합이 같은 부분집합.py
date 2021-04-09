import sys

# 합이 같은 부분집합
# N개의 원소로 구성된 자연수 집합이 주어진다.
# 이 집합을 두 개의 부분집합으로 나누었을 때,
# 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 'YES' 출력, 아니라면 'NO'를 출력한다.
# 둘로 나뉘는 두 부분집합은 서로소 집합이고, 두 부분집합을 합하면 입력으로 주어진
# 원래의 집합이 되어야 한다.
# 예를 들면 {1, 3, 5, 6, 7, 10} 이 입력되면 {1, 3, 5, 7} = {6, 10}으로 두 부분집합의
# 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

sys.stdin=open("input4.txt","r")

def DFS(x,yflag):
    if x==n:
        sum1=0
        sum2=0
        for i in range(n):
            if flag[i]==1:
                sum1+=nList[i]
            else:
                sum2+=nList[i]
        if sum1==sum2:
            yflag=1
        return yflag
    else:
        flag[x]=1
        yflag=DFS(x+1,yflag)
        flag[x]=0
        yflag=DFS(x+1,yflag)
    return yflag




if __name__=="__main__":
    n=int(input())
    nList=list(map(int, input().split()))
    flag=[0]*n
    y=DFS(0,0)
    if y==1:
        print("YES")
    else:
        print("NO")

