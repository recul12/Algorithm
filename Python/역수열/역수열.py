import sys

# 1부터 n까지 수를 한 번씩만 사용해 이루어진 수열이 존재한다
# 각각의 수 앞에 놓여 있는 자신보다 큰 수들의 개수를 수열로 표현한 것을 역수열이라 한다.
# 예를 들면 4 8 6 2 5 1 3 7 의 역수열은 5 3 4 0 2 1 1 0 이 된다.
# n과 1 부터 n까지의 수를 사용하여 이루어진 수열의 역수열이 주어졌을 때, 원래의 수열을 출력하라.

sys.stdin=open("input10.txt","r")

n=int(input())
n_list=list(map(int,input().split()))

# 자신보다 큰 수의 개수를 찾기 위해 inf로 이루어진 수열을 만든다.
inf=9999
x=[inf]*n

# 역수열의 각 index 는 index 보다 큰 수가 앞에 몇 개인지를 가리킨다.
# loop를 돌면서 지금 역수열 각 index 안의 수만큼 큰 수를 센 뒤에
# 다 세었다면 그 뒤에 inf 대신에 index를 넣어준다.
# index=idx+1

for idx in range(n):
    # bignum 변수에 index 보다 큰 수의 개수를 넣어준다.
    bignum = n_list[idx]

    # 개수를 세어줄 cnt 변수 생성
    cnt=0

    # 현재 bignum 과 cnt 의 개수를 비교하기 위한 루프 생성
    for j in range(n):

        # bignum 과 cnt 가 같아진다면 x 배열 내부에 현재 index 보다 적은 값이
        # 존재하는지 파악하고, 현재 x[j] 가 더 작다면 다음 x[j]로 넘어간다.
        # 남은 자리에 넣었다면 break
        if bignum==cnt:
            if x[j]<idx+1:
                continue
            x[j]=idx+1
            break
        # 현재 x[j] 가 index보다 크다면 cnt 를 더해준다.
        if x[j]>idx+1:
            cnt+=1
        # 더 작다면 넘어간다.
        else:
            continue

for i in range(n):
    print(x[i], end=" ")