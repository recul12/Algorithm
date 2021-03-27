import sys
from operator import itemgetter
# 회의실 사용표 만들기
# n개의 회의 존재
# 각 회의는 시작시간과 끝나는 시간이 있다.
# 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의는?
# 단, 회의는 중단되지 않으며 끝나면 바로 다음 회의를 시작할 수 있다.

sys.stdin = open("input5.txt" , "r")

n=int(input())

meet=[list(map(int,input().split())) for _ in range(n)]

meet.sort(key=itemgetter(1))

x=[0]*n
cnt=0

for i in range(n):
    if meet[i][0]>=meet[x[cnt]][1]:
        cnt+=1
        x[cnt]=i

print(cnt+1)