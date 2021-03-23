import sys

sys.stdin=open("input.txt","r")

n,m=map(int,input().split())

k=list(map(int,input().split()))

k.sort()

def binary_sort(list,start,end,target):
    if start>end:
        return -1
    mid=int((start+end)/2)
    if list[mid]==target:
        return mid
    elif list[mid]>target:
        return binary_sort(list,start,mid,target)
    else:
        return binary_sort(list,mid+1,end,target)

res=binary_sort(k,0,n-1,m)+1
print(res)
