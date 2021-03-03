import sys

def digit_sum(x):
    sum=0
    while(x>0):
        sum+=x%10
        x=x//10
    return sum


sys.stdin=open("input.txt","r")

n=int(input())
a=list(map(int,input().split()))

max=float('-inf')
for x in a:
    tot=digit_sum(x)
    if tot>max:
        max=tot
        res=x
print(res)