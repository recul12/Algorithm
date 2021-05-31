import sys

# 최대 선 연결하기
# 왼쪽 오른쪽 번호가 있는 그림에서 같은 번호끼리 선으로 연결하고자 한다.
# 왼쪽 번호는 위에서부터 차례로 1부터 N까지 오름차순으로 나열되어있다.
# 오른쪽의 번호 정보가 위부터 아래 순서로 주어지면 서로 선이 겹치지 않고 최대 몇 개의
# 선을 연결할 수 있는지 구하는 프로그램을 작성하시오
def LIS():
    idx=1
    for i in range(n):
        if dp[idx]<s[i]:
            idx+=1
            dp[idx]=s[i]
        else:
            start, end=1, idx
            while end>start:
                mid=(start+end)//2
                if dp[mid]>=s[i]:
                    end=mid
                else:
                    start=mid+1
            dp[end]=s[i]
    return idx

sys.stdin=open("input6.txt","r")

if __name__=="__main__":
    n=int(input())
    s=list(map(int,input().split()))
    INF=2147000000
    dp=[INF]*n
    dp.insert(0,-INF)
    idx=LIS()
    print(idx)