import sys

sys.stdin = open("input5.txt","r")

# N*N 격자판 안에 감을 말리고 있다.
# 모든 감을 잘 말리기 위해 격자를 왼쪽, 오른쪽으로 위치를 변경시키고 싶다.
# 잘 말리기 위한 회전명령 정보가 m개 들어온다.
# 회전명령 정보의 첫 번째 수는 행번호, 두 번째 수는 방향(0 left, 1 right)
# 세 번째 수는 회전하는 격자의 수이다.
# 이 때 모래시계 모양 영역에는 감 총 몇개인지 구하라.

n=int(input())
a=[list(map(int,input().split())) for _ in range(n)]
m=int(input())
b=[list(map(int,input().split())) for _ in range(m)]

#왼쪽으로 회전하는 함수
def cycle_left(x,n):
    for i in range(n):
        tmp = x[0]
        for j in range(len(x)-1):
            x[j]=x[j+1]
        x[len(x)-1]=tmp
    return x
#오른쪽으로 회전하는 함수
def cycle_right(x,n):
    for i in range(n):
        tmp = x[len(x) - 1]
        for j in range(len(x)-2,-1,-1):
            x[j+1]=x[j]
        x[0]=tmp
    return x

for i in range(m):
    if b[i][1]==0:
        cycle_left(a[b[i][0]-1],b[i][2])
    else:
        cycle_right(a[b[i][0]-1],b[i][2])

s=0
e=n
res=0
for i in range(n):
    for j in range(s,e):
        res+=a[i][j]
    if i<n//2:
        s+=1
        e-=1
    else:
        s-=1
        e+=1

print(res)
