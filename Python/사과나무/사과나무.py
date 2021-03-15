import sys

# N*N 격자판이 있고 각 격자 안에는 한 그루의 사과나무가 존재
# N의 크기는 항상 홀수이며, 다이아몬드 모양 안의 격자판만 수확하려한다.
# 총 사과 수확 개수를 구하시오

sys.stdin = open("input4.txt","r")

n=int(input())
a=[list(map(int,input().split())) for _ in range(n)]

# 첫 행의 가운데 격자로 시작해 2칸씩 늘어나므로 가운데를 시작,끝 지점으로 정한다.
# n/2행의 위치에 도달할 때까지 시작은 -1, 끝은 +1로 늘려주고, n/2행에 도착하면
# 반대로 줄여준다.
# 늘려주고 줄여주는 범위 안의 숫자들을 결과에 모두 더한다.

res=0
s=e=n//2
for i in range(n):
    for j in range(s,e+1):
        res+=a[i][j]
    if i<n//2:
        s-=1
        e+=1
    else:
        s+=1
        e-=1


print(res)
