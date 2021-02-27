import sys
sys.stdin=open("input.txt","rt")

n=1
tmp=[]
T = int(input())
for i in range(T):
    N, s, e, k = map(int, input().split())
    #s부터 e번째 까지 오름차순 정렬
    tmp=list(map(int,input().split()))
    tmp=tmp[s-1:e]
    tmp.sort()
    print("#%d %d" %(i+1, tmp[k-1]))