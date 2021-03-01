#뒤집은 소수

import sys

sys.stdin = open("input.txt","r")

n=int(input())
a=list(map(int,input().split()))


def reverse(x):
    #배열에 숫자를 넣는다.
    tmp=''
    for i in range(len(str(x))):
        tmp+=str(x)[len(str(x))-1-i]
    return int(tmp)

def isPrime(x):
    if x==1:
        return False
    m=int(x**0.5)
    for i in range(2,m+1):
        if x%i==0:
            res=False
            break
    else:
        res=True

    return res

for i in a:
    ri=reverse(i)
    if(isPrime(ri)):
        print(ri,end=' ')