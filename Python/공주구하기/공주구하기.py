import sys
from collections import deque

# 공주 구하기
# 정보 왕국의 이웃 나라 외동 딸이 괴물에게 잡혀갔다.
# 정보 왕국에는 왕자가 N명이 존재한다.
# 왕은 왕자들을 나이 순으로 1번에서 N번까지 순서를 매긴다.
# 그리고 1번부터 N번까지 순서대로 시계 방향으로 동그랗게 앉게 한다.
# 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치는데,
# 한 왕자가 K를 외치면 그 왕자는 공주를 구하러 가는데 제외되고 원 밖으로 나가게된다.
# 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
# 이렇게 해서 마지막 왕자가 공주를 구하러 갈 수 있다.

sys.stdin= open("input5.txt","r")

n,k=map(int,input().split())

queue=[]
queue=deque(queue)
for i in range(1,n+1):
    queue.append(i)

cnt=0
while queue:
    tmp=queue.popleft()
    cnt+=1
    if cnt==k:
        cnt=0
        continue
    queue.append(tmp)

print(tmp)
