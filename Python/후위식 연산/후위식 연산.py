import sys

sys.stdin=open("input4.txt","r")

n=input()

stack=[]

for x in n:
    if x.isdecimal():
        stack.append(int(x))
    else:
        if x == '+':
            p=stack.pop()+stack.pop()
            stack.append(p)
        elif x=='-':
            p = -(stack.pop() - stack.pop())
            stack.append(p)
        elif x=='*':
            p=stack.pop()*stack.pop()
            stack.append(p)
        else:
            a=stack.pop()
            b=stack.pop()
            p = b/a
            stack.append(p)
res=stack.pop()
print(res)