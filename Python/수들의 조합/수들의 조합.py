import sys

# 수들의 조합
# N개의 정수가 주어지면 그 숫자 중 K개를 뽑는 조합의 합이 임의의 정수 M의 배수인 개수는 몇 개인지
# 출력하는 프로그램을 작성
# 5개의 숫자 2 4 5 8 12개 주어지고 3개를 뽑은 조합의 합이 6의 배수인 조합을 찾으면
# 4+8+12 2+4+12로 2가지가 있다.

sys.stdin=open("input11.txt","r")

def DFS(depth,x,sum):
    global cnt
    if depth==k:
        if sum%m==0:
            cnt+=1
    else:
        for i in range(x,n):
            DFS(depth+1,i+1,sum+nList[i])

if __name__ == "__main__":
    n, k = map(int, input().split())
    nList=list(map(int,input().split()))
    m=int(input())
    cnt=0
    DFS(0,0,0)
    print(cnt)