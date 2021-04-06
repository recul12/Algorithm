import sys

# 단어 찾기
# 시에 쓰일 단어 적기
# N개의 단어를 노트에 적었는데 시에 쓰지 않은 단어가 하나 있다.
# 이걸 찾아 출력.

sys.stdin=open("input8.txt","r")

n=int(input())

note=list(input() for _ in range(n))

poem=list(input() for _ in range(n-1))

for x in note:
    if not x in poem:
        print(x)
        break
