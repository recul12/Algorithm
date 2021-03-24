import sys

# DVD 내에는 총 N곡이 삽입되고
# 1번과 5번 곡을 DVD 에 녹화하기 위해서는 1,2,3,4,5 와 같이 순서를 지켜서 모두 녹화해야한다.
# 또한 한 노래를 쪼개서 2개의 DVD에 넣는 것도 불가능하다.
# 이 때, DVD 의 개수를 최소화하기 위해서 M개의 DVD 에 모든 동영상을 녹화하고,
# DVD의 크기(녹화 가능 길이)를 최소로 하려고 한다.
# M개의 DVD는 모두 같은 크기여야만 한다.

sys.stdin = open("input3.txt","r")

n,m=map(int,input().split())

songs=list(map(int,input().split()))

def countN(capacity):
    cnt=1
    sum=0
    for x in songs:
        if sum+x>capacity:
            cnt+=1
            sum=x
        else:
            sum+=x
    return cnt

maxx=max(songs)
lt=1
rt=sum(songs)
res=0

while lt <= rt:
    mid=(lt+rt)//2
    if mid>=maxx and m >= countN(mid):
        res = mid
        rt = mid - 1
    else:
        lt = mid + 1
print(res)
