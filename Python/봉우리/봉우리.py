import sys

sys.stdin=open("input6.txt","r")
n=int(input())
a=[list(map(int,input().split())) for _ in range(n)]

res=0
for i in range(n):
    for j in range(n):
        if i>0:
            up=a[i-1][j]
        else:
            up=0
        if j<n-1:
            right=a[i][j+1]
        else:
            right=0
        if i<n-1:
            down = a[i + 1][j]
        else:
            down=0
        if j>0:
            left=a[i][j-1]
        else:
            left=0
        if a[i][j]>up and a[i][j]>down and a[i][j]>right and a[i][j]>left:
            res+=1

print(res)