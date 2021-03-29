import sys

# 창고에 상자가 가로방향으로 l개 일렬로 쌓여있다.
# 6 3 9 7 2 8 6 의 개수로 쌓여있다고 가정하면
# 창고 높이 조정(가장 높은 곳의 상자를 가장 낮은 곳으로 이동)을 했을 때
# 6 3 8 7 3 8 6 이 개수가 된다.
# 조정을 할 때 가장 높거나 낮은 곳이 여러곳이면 아무거나 선택할 수 있다.
# m 회의 높이 조정 후 가장 높은 곳과 낮은 곳의 차이를 구하라.
sys.stdin=open("input7.txt","r")

l=int(input())
l_list=list(map(int,input().split()))
m=int(input())

for i in range(m):
    l_list.sort()
    l_list[0]+=1
    l_list[l-1]-=1

l_list.sort()
print(l_list[l-1]-l_list[0])
