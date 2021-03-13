import sys

sys.stdin=open("input2.txt","r")

n,m=map(int,input().split())

a_list=list(map(int,input().split()))
#경우의 수 카운트
cnt=0

for i in range(len(a_list)):
    if a_list[i]>m:
        continue
    elif a_list[i]<m:
        sum=a_list[i]
        for j in range(i + 1, len(a_list)):
            sum=sum+a_list[j]
            if sum==m:
                cnt+=1
                break
            elif sum>m:
                break
    else:
        cnt+=1

print(cnt)