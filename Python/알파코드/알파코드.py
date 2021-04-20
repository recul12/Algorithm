import sys

# 알파코드
# 알파벳 A부터 Z까지를 1~26으로 하고 번호를 보낸다.
# 번호를 보내서 25114 같은 것을 알파벳으로 복원할 경우 몇 가지 방법이 있는지 구하시오.

sys.stdin=open("input6.txt","r")

def DFS(depth):
    global cnt
    if depth==v:
        for x in tmp:
            print(chr(int(x)+64),end='')
        print()
        cnt+=1
    else:
        if int(n[depth])!=0:
            tmp.append(n[depth])
            DFS(depth+1)
            tmp.pop()
            if depth < v-1 and int(n[depth])<3 and int(n[depth+1])<7:
                tmp.append(n[depth]+n[depth+1])
                DFS(depth+2)
                tmp.pop()

if __name__=="__main__":
    n=list(input())
    tmp=[]
    v=len(n)
    cnt=0
    DFS(0)
    print(cnt)