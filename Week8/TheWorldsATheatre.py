n,m,t = map(int, input().split())


def fact(n):
    f = 1
    if n==0:
        return f
    for i in range(1,n+1):
        f=f*i
    return f
def ncr(n,r):
    return fact(n)//(fact(r)*fact(n-r))

sum = 0
for b in range(4, t):
    g = t-b
    sum += ncr(n,b)*ncr(m,g)

print(sum)