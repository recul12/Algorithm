import sys

# Anagram
# Anagram이란 두 문자열이 알파벳의 나열 순서는 다르지만 그 구성이 일치한 상태를 말한다.
# 예를 들면 AbaAeCe 와 BaeeACA는 알파벳 나열 순서는 다르지만 알파벳의 개수가 일치한다.
# 즉 재배열시 상대 단어가 될 수 있는 것을 아나그램이라고 한다.
# 두 단어가 주어질 시 아나그램인지 판별하는 프로그램을 작성하시오.

sys.stdin=open("input9.txt","r")

a=input()
b=input()

# 알파벳 개수 52개 세기 위한 배열
cntAlpha_a=[0]*52
cntAlpha_b=[0]*52
# 문자열 안에 알파벳 개수를 세는 장치
def alphaCount(string, list):
    for x in string:
        if x.islower():
            # 97-71=26 번의 인덱스부터는 lower alphabet 을 채운다.
            list[ord(x)-71]+=1
        else:
            # 0번부터는 upper alphabet 을 채운다.
            list[ord(x)-65]+=1
    return list

# 배열 두개 센 뒤 비교
cntAlpha_a=alphaCount(a,cntAlpha_a)
cntAlpha_b=alphaCount(b,cntAlpha_b)

for i in range(52):
    if cntAlpha_a[i]!=cntAlpha_b[i]:
        print("NO")
        break
else:
    print("YES")
