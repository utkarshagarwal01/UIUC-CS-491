N = 9999999999999999999999999999999999999984
n,m=tuple(map(int,input().split()))
mem = set()
for y in range(n):
    us = 0
    p_new = 1
    entry = input()
    for lett in entry:
        us = (us + p_new*ord(lett))%N
        p_new = (p_new*203)%N
    p_new = 1
    for lett in entry:
        for i in ['a','b','c']:
            if i != lett:
                mem.add((p_new*(ord(i)-ord(lett))+us)%N)
        p_new = (p_new*203)%N
answer  =[]
for x in range(m):
    us = 0
    p_new = 1
    for letter in input():
        us = (us + p_new*ord(letter))%N
        p_new = (p_new*203)%N
    if us in mem:
        answer.append('YES')
    else:
        answer.append('NO')

print('\n'.join(answer))