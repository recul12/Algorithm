
import sys

sys.stdin = open("input.txt","r")

n=int(input())
tmp=[0]*n
for i in range(n):
    tmp[i] = list(map(int, input().split()))

def dice_game(x):
    sum=0
    if x[0] == x[1] and x[0]== x[2]:
        sum=10000+(x[0]*1000)
    elif x[0] == x[1] or x[0] == x[2]:
        sum=1000+(x[0]*100)
    elif x[1] == x[2]:
        sum=1000+(x[1]*100)
    else:
        max=x[0]
        for i in range(3):
            if max<x[i]:
                max=x[i]
        sum=max*100
    return sum
max=0
for i in range(n):
    if max<dice_game(tmp[i]):
        max=dice_game(tmp[i])

print(max)
