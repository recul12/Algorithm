import sys

# 최대 부분 증가수열
# N개의 자연수로 이루어진 수열이 주어졌을 떄
# 그 중 가장 길게 증가하는 원소들의 집합을 찾는 프로그램을 작성하라.

def LIS():
    idx = 1
    for i in range(n):
        if dp[idx]<s[i]:
            idx+=1
            dp[idx]=s[i]
        else:
            start,end=1,idx
            while start<end:
                mid=(start+end)//2
                if dp[mid]>=s[i]:
                    end=mid
                else:
                    start=mid+1
            dp[end]=s[i]
    return idx



sys.stdin=open("input5.txt","r")

if __name__=="__main__":
    n=int(input())
    s=list(map(int,input().split()))
    INF = 2147000000
    dp=[INF]*n
    dp.insert(0,-INF)
    idx=LIS()
    print(idx)
