#정다면체
import sys

sys.stdin=open("input.txt","r")

n,m=map(int,input().split())

cnt=[0]*(n+m+1)
max=0
for i in range(1,n+1):
    for j in range(1,m+1):
        cnt[i+j]+=1

for i in range(n+m+1):
    if max<cnt[i]:
        max=cnt[i]

for i in range(n+m+1):
    if max==cnt[i]:
        print(i, end=' ')
