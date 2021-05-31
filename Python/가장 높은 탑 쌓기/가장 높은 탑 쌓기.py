import sys

# 가장 높은 탑 쌓기
# 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다.
# 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어간다.
# 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하라.
# 1. 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
# 2. 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
# 3. 벽돌들의 높이는 같을 수도 있다.
# 4. 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
# 5. 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.


sys.stdin=open("input7.txt","r")

if __name__=="__main__":
    n=int(input())
    bricks=[]
    for i in range(n):
        a, b, c=map(int, input().split())
        bricks.append((a, b, c))
    bricks.sort(reverse=True)
    dy=[0]*n

    dy[0]=bricks[0][1]
    res=bricks[0][1];
    for i in range(1, n):
        max_h=0;
        for j in range(i-1, -1, -1):
            if bricks[j][2]>bricks[i][2] and dy[j]>max_h:
                max_h=dy[j]
        dy[i]=max_h+bricks[i][1]
        res=max(res, dy[i])
    print(res)
    