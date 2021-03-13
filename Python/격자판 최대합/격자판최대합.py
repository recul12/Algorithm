import sys

sys.stdin=open("input3.txt")

n=int(input())
a=[list(map(int,input().split())) for _ in range(n)]

def rowsum(x,n):
    sum=0
    for i in range(len(x)):
        sum+=x[n-1][i]
    return sum

def colsum(x,n):
    sum=0
    for i in range(len(x)):
        sum+=x[i][n-1]
    return sum

def diagsum(x):
    sum1,sum2=0,0
    for i in range(len(x)):
        sum1+=x[i][i]
    for j in range(len(x)):
        sum2+=x[j][len(x)-1-j]
    if sum1>sum2:
        return sum1
    else:
        return sum2

max=diagsum(a)
for i in range(len(a)):
    if max<rowsum(a,i):
        max=rowsum(a,i)
    if max<colsum(a,i):
        max=colsum(a,i)

print(max)