import sys

# 계단오르기
# 네트워크 선과 문제가 똑같다.
# 계단을 오를 때 한 계단, 두 계단씩 올라가서 N개의 계단을 올라가는
# 방법의 수를 구하라.

def DFS(len):
    if dy[len] > 0:
        return dy[len]
    if len == 1 or len == 2:
        return len
    else:
        dy[len] = DFS(len - 1) + DFS(len - 2)
        return dy[len]


sys.stdin=open("input3.txt","r")

if __name__=="__main__":
    n=int(input())
    dy=[0]*(n+1)
    print(DFS(n))