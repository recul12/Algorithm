import sys
#대표값 구하기
sys.stdin=open("input.txt","r")

n=int(input())
a=list(map(int,input().split()))

avg=sum(a)/n
avg=avg+0.5
avg=int(avg)
min=2147000000
for idx, x in enumerate(a):
    tmp=abs(x-avg)
    if tmp<min:
        min=tmp
        score=x
        res=idx+1
    elif tmp==min:
        if x>score:
            score=x
            res=idx+1
print(avg, res)
