import sys

# 엘리트 학원이 자체적으로 K개의 랜선을 가지고있고
# K개의 랜선을 잘라서 N개의 길이가 같은 랜선을 구하려고 한다.
# 이 때, 랜선을 자를때 손실되는 길이는 없다고 가정하고
# 기존의 K개 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다.
# 센티미터 단위 정수의 길이로 자르고, N개 보다 많이 만드는것도 N개를 만드는 것에 포함된다.
# 이 때 만들 수 있는 최대 랜선 길이

sys.stdin = open("input2.txt","r")

k, n = map(int, input().split())

k_list=list(int(input()) for _ in range(k))

# 배열 안에 있는 랜선들을 현재 길이로 잘라 나온 수를 구하는 함수
def countN(len):
    cnt = 0
    for x in k_list:
        cnt += x//len
    return cnt


largest = 0
# largest 와 k_list 의 요소를 비교하여 더 큰것을 largest 에 넣기
for i in range(k):
    tmp = k_list[i]
    largest = max(tmp, largest)

# 비교해서 범위를 좁혀주는 이진탐색을 위해 left 에 0, right 에 largest 를 넣어준다.
lt = 0
rt = largest

# 랜선의 개수와 맞는지 비교를 하기 위하여 루프로 진입한다.
# left 와 right 의 가운데 숫자인 mid 를 구한다.
# n과 mid 로 랜선을 나눈 countN 함수를 비교해서 수가 같으면 결과를 설정하고
# 더 높은 수가 있는지 찾고 없다면 그 결과를 답으로 설정
res = 0
while lt<=rt:
    mid = (lt+rt)//2
    if n <= countN(mid):
        res = mid
        lt = mid+1
    else:
        rt = mid-1

print(res)