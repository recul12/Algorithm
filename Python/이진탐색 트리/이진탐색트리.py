# 이진탐색트리 전위,중위,후위 구현

def DFS(v):
    if v > 7:
        return
    else:
        print(v, end=' ')
        DFS(v * 2)
        DFS(v * 2 + 1)


if __name__ == "__main__":
    DFS(1)