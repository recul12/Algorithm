import sys

# 최소 힙
# 최소힙은 완전이진트리로 구현된 자료구조이다.
# 구성은 부모 노드값이 왼쪽, 오른쪽 자식노드값보다 작게 트리를 구성하는 것.
# 그렇게 하면 트리의 루트노드는 입력된 값들 중 가장 작은 값이 저장되어있다.
# 최소 힙 자료를 이용하여 다음 연산을 하는 프로그램 작성하라.
# 1) 자연수가 입력되면 최소힙에 입력한다.
# 2) 숫자 0이 입력되면 최소힙에서 최솟값을 꺼내어 출력한다.
# 3) -1이 입력되면 프로그램을 종료한다.

sys.stdin=open("input10.txt","r")

minheap=[0]

def insertMinHeap(Heap,item):
    Heap.append(item)
    p = len(Heap)-1
    while p>1 and Heap[p]<Heap[int(p/2)]:
        tmp=Heap[int(p/2)]
        Heap[int(p/2)]=Heap[p]
        Heap[p]=tmp
        p=int(p/2)



def deleteMinHeap(Heap):
    if len(Heap)-1<1:
        print("0")
        return
    item=Heap[1]
    Heap[1]=Heap[len(Heap)-1]
    Heap.pop()

    pos=1
    while (pos*2)<len(Heap):
        smallest=Heap[pos*2]
        minPos=pos*2

        if minPos+1<len(Heap) and smallest>Heap[minPos+1]:
            smallest=Heap[minPos+1]
            minPos+=1

        if Heap[pos]<smallest:
            break

        tmp=Heap[pos]
        Heap[pos]=smallest
        Heap[minPos]=tmp
        pos=minPos

    return item


while True:
    #자연수 입력
    a=int(input())
    #-1이면 종료
    if a==-1:
        break
    #0이면 최소힙에서 최솟값을 꺼내거나 없으면 종료
    elif a==0:
        if len(minheap)<=1:
            print("-1")
            break
        else:
            print(deleteMinHeap(minheap))
    # 힙에 저장
    else:
        insertMinHeap(minheap, a)

