import sys

# 최대 힙
# 최대힙은 완전이진트리로 구현된 자료구조이다.
# 구성은 부모 노드값이 왼쪽, 오른쪽 자식노드값보다 크게 트리를 구성하는 것.
# 그렇게 하면 트리의 루트노드는 입력된 값들 중 가장 큰 값이 저장되어있다.
# 최대 힙 자료를 이용하여 다음 연산을 하는 프로그램 작성하라.
# 1) 자연수가 입력되면 최대힙에 입력한다.
# 2) 숫자 0이 입력되면 최대힙에서 최댓값을 꺼내어 출력한다.
# 3) -1이 입력되면 프로그램을 종료한다.

sys.stdin=open("input11.txt","r")

maxheap=[0]

def insertMaxHeap(Heap,item):
    Heap.append(item)
    p = len(Heap)-1
    while p>1 and Heap[p]>Heap[int(p/2)]:
        tmp=Heap[int(p/2)]
        Heap[int(p/2)]=Heap[p]
        Heap[p]=tmp
        p=int(p/2)

def deleteMaxHeap(Heap):
    if len(Heap)-1<1:
        print("0")
        return
    item=Heap[1]
    Heap[1]=Heap[len(Heap)-1]
    Heap.pop()

    pos=1
    while (pos*2)<len(Heap):
        largest=Heap[pos*2]
        maxPos=pos*2

        if maxPos+1<len(Heap) and largest<Heap[maxPos+1]:
            largest=Heap[maxPos+1]
            maxPos+=1

        if Heap[pos]>largest:
            break

        tmp=Heap[pos]
        Heap[pos]=largest
        Heap[maxPos]=tmp
        pos=maxPos

    return item


while True:
    #자연수 입력
    a=int(input())
    #-1이면 종료
    if a==-1:
        break
    #0이면 최소힙에서 최솟값을 꺼내거나 없으면 종료
    elif a==0:
        if len(maxheap)<=1:
            print("-1")
            break
        else:
            print(deleteMaxHeap(maxheap))
    # 힙에 저장
    else:
        insertMaxHeap(maxheap, a)

