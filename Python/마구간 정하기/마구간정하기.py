import sys

# 수직선 상의 N개의 마구간
# 각 마구간은 x1, x2, x3, ... , xN의 좌표를 가진다.
# C마리의 말이 있고, 서로 가까이 있는 것을 싫어한다.
# 각 마구간에는 한마리의 말만 들어갈 수 있고, 가장 가까운 두 말의 거리가 최대가 되어야한다.
# C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되려면?


sys.stdin=open("input4.txt","r")

def countN(len):
    cnt=1
    ep=x_list[0]
    for i in range(1,n):
        if x_list[i]-ep>=len:
            cnt+=1
            ep=x_list[i]
    return cnt

n,c=map(int,input().split())

x_list=list(int(input()) for _ in range(n))
x_list.sort()

lt=1
rt=x_list[n-1]

while lt<=rt:
    mid=(lt+rt)//2
    if countN(mid) >= c:
        res=mid
        lt=mid+1
    else:
        rt=mid-1

print(res)