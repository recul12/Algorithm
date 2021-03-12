import sys

sys.stdin = open("input1.txt","r")

n=int(input())
list1=list(map(int,input().split()))
m=int(input())
list2=list(map(int,input().split()))

def merge(list1,list2):
    sort_list=[0]*(len(list1)+len(list2))
    i,j,k=0,0,0
    while i<len(list1) and j<len(list2):
        if list1[i]>list2[j]:
            sort_list[k]=list2[j]
            j+=1
            k+=1
        elif list1[i]<list2[j]:
            sort_list[k]=list1[i]
            i+=1
            k+=1
        else:
            sort_list[k]=list1[i]
            i+=1;k+=1
            sort_list[k]=list2[j]
            j+=1;k+=1

    if i>=len(list1):
        for t in range(j,len(list2)):
            sort_list[k]=list2[t]
            k+=1
    elif j<=len(list2):
        for t in range(i,len(list1)):
            sort_list[k]=list1[t]
            k+=1
    return sort_list

slist=merge(list1,list2)

for i in slist:
    print(i, end=" ")