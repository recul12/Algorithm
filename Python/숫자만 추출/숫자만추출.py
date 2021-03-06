import sys

#문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듦
#만들어진 자연수와 그 자연수의 약수 개수를 출력
#만약 “t0e0a1c2h0er”에서 숫자만 추출하면 0, 0, 1, 2, 0이고 이것을 자연수를 만들면 120
#추출하여 만들어지는 자연수는 100,000,000을 넘지 않는다
sys.stdin = open("input.txt","r")

mixed_str=input()
tmp=""
for i in range(len(mixed_str)):
    if mixed_str[i].isdigit():
        tmp=tmp+mixed_str[i]

tmp=int(tmp)

n=int(tmp**0.5)
cnt=0

for i in range(1,n+1):
    if tmp%i==0:
        if i != int(tmp/i):
            cnt+=2
        else:
            cnt+=1
print(tmp)
print(cnt)
