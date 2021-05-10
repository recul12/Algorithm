import sys

# 네트워크 선 자르기(topdown)
# 현수는 네트워크 선을 1m, 2m 길이를 갖는 선으로 자르려고 한다.
# 네트워크 길이가 Nm라면 몇 가지의 자르는 방법을 생각할 수 있는지 구하라.
def DFS(len):
    if dy[len] > 0:
        return dy[len]
    if len == 1 or len == 2:
        return len
    else:
        dy[len] = DFS(len - 1) + DFS(len - 2)
        return dy[len]


sys.stdin=open("input2.txt","r")

if __name__=="__main__":
    n=int(input())
    dy=[0]*(n+1)
    print(DFS(n))