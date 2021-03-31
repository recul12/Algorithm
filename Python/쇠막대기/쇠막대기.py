import sys

# 쇠막대기를 레이저로 제거
# 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
# 단, 끝점은 겹치지 않도록 놓는다.
# 각 쇠막대기를 자르는 레이저는 최소 하나 존재한다.
# 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
# 이 때, 레이저는 괄호 ()로 표현된다. 쇠막대기의 왼쪽 끝은 (, 오른쪽 끝은 )이다.

sys.stdin=open("input2.txt","r")

n=input()

stack=[]

cnt=0
for i in range(len(n)):
    if n[i]=='(':
        stack.append(n[i])
    else :
        stack.pop()
        if n[i-1]=='(':
            cnt+=len(stack)
        else:
            cnt+=1

print(cnt)

