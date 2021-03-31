import sys

# 숫자 하나를 받아서 해당 숫자의 자릿수들 중 m개의 숫자를 제거한다.
# m개의 숫자가 제거 된 후 남는 숫자는 가장 큰 수가 되어야한다.
# 예를 들어 5276823이 주어지고 3개의 자릿수를 제거하면
# 7823이 가장 큰 숫자가 된다.

sys.stdin=open("input.txt","r")

n,m=map(int, input().split())

x=[]
while n!=0:
    x.insert(0,n%10)
    n=n//10

n_list1=[]

n_len=len(x)-m

while x:
    tmp=x.pop()
    if len(n_list1) < n_len:
        n_list1.insert(0,tmp)
        continue
    if tmp>=n_list1[0]:
        minimum=n_list1[0]
        for i in n_list1:
            if i>minimum:
                break
            else:
                minimum=i
        n_list1.remove(minimum)
        n_list1.insert(0,tmp)

for i in n_list1:
    print(i,end="")
