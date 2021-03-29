import sys

# 타이타닉 침몰이 침몰 중이다.
# N명의 승객이 구명보트를 타려고 하는데 타이타닉 구명보트는 2명 이하로만 탈수 있다.
# 보트 한 개의 탈 수 있는 총 무게도 M kg 이하로 제한되어 있다.
# N명의 승객의 몸무게가 주어졌을 때 구명보트의 최소개수를 구하라.

sys.stdin=open("input8.txt","r")

n, m=map(int, input().split())

n_list=list(map(int, input().split()))
# 승객을 몸무게 순으로 정렬
n_list.sort()

cnt=0
while n_list:
    if len(n_list)==1:
        cnt+=1
        break
    if n_list[0]+n_list[-1]>m:
        n_list.pop()
        cnt+=1
    else:
        n_list.pop(0)
        n_list.pop()
        cnt+=1

print(cnt)


