import sys

# 재귀함수를 이용한 이진수 출력
# 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램 작성
# 단, 재귀함수를 이용하여 출력하라.
def DFS(n):
    if n==1:
        return '1'
    if n//2==1:
        if n==3:
            return '11'
        elif n==2:
            return '10'
    else:
        return DFS(n//2)+str(n%2)


sys.stdin=open("input.txt","r")

n=int(input())

print(DFS(n))