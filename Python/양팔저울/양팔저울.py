import sys

# 양팔저울
# 무게가 서로 다른 K개의 추와 빈 그릇이 있다.
# 모든 추의 무게는 정수이고 그릇의 무게는 0으로 가정한다.
# 양팔저울을 한 번만 이용하여 원하는 물의 무게를 그릇에 담고자 한다.
# 주어진 모든 무게 추의 합을 S라 하면, 추가 3개이고 {1, 2, 6} 의 무게를 가질 때
# S=9이고 양팔저울을 한 번만 이용하여 1부터 S 사이에 대응되는 모든 무게의 물을
# 그릇에 담을 수 있다. X는 그릇에 담는 물의 무게이다.
# K개의 추 무게가 주어질 때, 1부터 S사이 정수 중 측정이 불가능한 물의 무게는 몇개가 있는지
# 출력하는 프로그램을 작성하라.

sys.stdin=open("input3.txt","r")

def DFS(depth, sum):
    global res
    if depth==n:
        if 0<sum<=s:
            res.add(sum)
    else:
        DFS(depth + 1, sum+a[depth])
        DFS(depth + 1, sum-a[depth])
        DFS(depth + 1, sum)

if __name__=="__main__":
    n=int(input())
    a=list(map(int,input().split()))
    s=sum(a)
    res=set()
    DFS(0,0)
    print(s-len(res))

