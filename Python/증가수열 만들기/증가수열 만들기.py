import sys

sys.stdin=open("input9.txt","r")

n=int(input())
n_list=list(map(int,input().split()))

last=0
lt=0
rt=n-1
tmp=[]
res=""
while lt<=rt:
    if n_list[lt]>last:
        tmp.append((n_list[lt],"L"))
    if n_list[rt]>last:
        tmp.append((n_list[rt],"R"))
    tmp.sort()
    if len(tmp)==0:
        break
    else:
        res=res+tmp[0][1]
        last=tmp[0][0]
        if tmp[0][1]=='L':
            lt+=1
        else:
            rt-=1
    tmp.clear()
print(len(res))
print(res)