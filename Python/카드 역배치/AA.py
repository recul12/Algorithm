import sys

#구간 a~b의 카드를 역순으로
def reverse_card(x,a,b):
    tmp=x[a-1:b]
    tmp=tmp[::-1]
    cnt=0
    for i in range(a-1,b):
        x[i]=tmp[cnt]
        cnt+=1

sys.stdin=open("input.txt","r")

card_list=list(range(1,21))

for i in range(10):
    ai,bi=map(int,input().split())
    reverse_card(card_list,ai,bi)

for i in range(len(card_list)):
    print(card_list[i], end=' ')