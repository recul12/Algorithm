import sys

sys.stdin=open("input.txt","r")

n=int(input())

cnt=[True]*(n+1)
m=int(n**0.5)

for i in range(2,m+1):
    if cnt[i]==True:
        for j in range(i+i,n+1,i):
            cnt[j]=False

res=[i for i in range(2,n+1) if cnt[i]==True]
res_len=len(res)
print(res_len)