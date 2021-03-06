import sys

#N개의 문자열 데이터를 입력받아 앞에서 읽을 때나 뒤에서 읽을 때나 같은 경우(회문 문자열)
#이면 YES를 출력하고 회문 문자열이 아니면 NO를 출력하는 프로그램을 작성
#회문 검사시 대소문자 구분 X
sys.stdin=open("input.txt","r")

n=int(input())
str_list=['']*n
for i in range(n):
    str_list[i]=input()

def reverse_str(x):
    x=x.lower()
    for i in range(int(len(x)/2)):
        if x[i]!=x[len(x)-1-i]:
            res=False
            break
    else:
        res=True

    return res

for i in range(n):
    res=reverse_str(str_list[i])
    if res==True:
        print(f"#{i+1} YES")
    else:
        print(f"#{i+1} NO")
