import sys

# 네트워크 선 자르기(Bottomup)
# 현수는 네트워크 선을 1m, 2m 길이를 갖는 선으로 자르려고 한다.
# 네트워크 길이가 Nm라면 몇 가지의 자르는 방법을 생각할 수 있는지 구하라.

sys.stdin=open("input.txt","r")

n=int(input())
dy=[0]*(n+1)
dy[1]=1
dy[2]=2
for i in range(3, n+1):
    dy[i]=dy[i-1]+dy[i-2]

print(dy[n])