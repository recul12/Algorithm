import sys

sys.stdin = open("input8.txt","r")

a=[list(map(int,input().split())) for _ in range(7)]


res=0
for i in range(len(a)):
    s = 0
    e = s + 4
    while e<len(a):
        if a[i][s] == a[i][e]:
            if a[i][s+1]==a[i][e-1]:
                res += 1
        s += 1
        e += 1
    s = 0
    e = s + 4
    while e<len(a):
        if a[s][i] == a[e][i]:
            if a[s+1][i]==a[e-1][i]:
                res += 1
        s += 1
        e += 1

print(res)