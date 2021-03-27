import sys
from operator import itemgetter

# N명의 지원자가 씨름 선수로 지원
# 선발 원칙은 일대일 비교로 키 몸무게중 적어도 하나가 크면 뽑는다.

sys.stdin=open("input6.txt","r")

n=int(input())

people=[list(map(int,input().split())) for _ in range(n)]

# 키 순서로 내림차순 정렬
people.sort(key=itemgetter(0),reverse=True)

# 첫 번째 선수는 키가 가장 크므로 무조건 통과
# 두 번째 선수의 몸무게가 첫 번째 선수보다 높다면 뽑힌다.
# 그렇게 된다면 다음 기준은 두 번째 선수로 넘어가고, 나머지 선수의 키는
# 모두 두 번째 선수보다 작으므로 두 번째 선수보다 몸무게가 높아야한다.

# 뽑힌 선수 cnt 와 선수 이동을 위한 배열 생성
# 첫 번째 선수는 무조건 뽑히므로 cnt=1이어야 하지만 배열을 세기 위해 1이 아닌 0으로 생성
cnt=0
x=[0]*n
print(people)
for i in range(n):
    if people[i][1]>people[x[cnt]][1]:
        cnt+=1
        x[cnt]=i

# 뽑히는 cnt 와 기존 첫 번째 선수를 더한 수를 출력
print(cnt+1)