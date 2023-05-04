
def fact(n):
    f = 1
    if n==0:
        return f
    for i in range(1,n+1):
        f=f*i
    return f
def ncr(n,r):
    return fact(n)//(fact(r)*fact(n-r))

def solve(n, a):
    countMax = 0
    countMaxLessOne = 0
    maxValue = max(a)
    for i in a:
        if i == maxValue:
            countMax += 1
        if i == maxValue - 1:
            countMaxLessOne += 1

        
    return fact(n) - (fact(n)//(countMaxLessOne+1))

t=int(input())
while t:
    n=int(input())
    a = map(int, input().split())
    print(solve(n,a))
    t-=1