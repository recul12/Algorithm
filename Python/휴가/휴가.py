import sys

# 휴가
# 현수는 오늘부터 N+1일째 되는 날 휴가를 떠나기 위해서
# 남은 N일 동안 최대한 많은 상담을 해서 휴가비를 넉넉히 만들어 휴가를 떠나려 한다.
# 현수가 다니는 회사에 하루에 하나씩 서로 다른 사람의 상담이 예약되어 있다.
# 각각의 상담은 상담을 완료하는데 걸리는 날 수 T와 상담을 했을 때 받을수 있는 금액 P로 이루어져있다.
# 휴가를 가기 위해 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하라.

sys.stdin=open("input2.txt","r")

def DFS(depth, p):
    global res
    if depth==n+1:
        if res<p:
            res=p
    else:
        if depth+tList[depth]<=n+1:
            DFS(depth+tList[depth],p+pList[depth])
        DFS(depth+1,p)

if __name__=="__main__":
    n=int(input())
    tList=list()
    pList=list()
    for i in range(n):
        a,b=map(int,input().split())
        tList.append(a)
        pList.append(b)
    res=0
    tList.insert(0,0)
    pList.insert(0,0)
    DFS(1,0)
    print(res)