#OX 문제 점수 계산
import sys

sys.stdin = open("input.txt","r")

n=int(input())
a=list(map(int,input().split()))

#답 리스트 추가
answer=[0]*n
#flag를 만들어서 답을 맞춘경우 1 틀리면 0, stack으로 연속맞추는 스택 쌓기, 답 전체를 더하는 sum
flag=0
stack=0
sum=0
for i in range(n):
    if flag==0:
        if a[i]==1:
            flag=1
            answer[i]+=1
            stack+=1
        else:
            answer[i]=0
    else:
        if a[i]==1:
            stack += 1
            answer[i]+=stack
        else:
            answer[i]=0
            stack=0

for i in range(n):
    sum+=answer[i]
print(sum)