def solution(str1, str2):
    dp = [[0 for i in range(len(str2)+1)] for j in range(len(str1)+1)]
    for i in range(len(str2)+1):
        dp[0][i] = i
    for j in range(len(str1)+1):
        dp[j][0] = j
    
    for i in range(1,len(str1)+1):
        for j in range(1,len(str2)+1):
            if str1[i-1]==str2[j-1]:
                cost = 0
            else:
                cost = 1
            
            dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+cost)
    
    print(dp[len(str1)][len(str2)])
    
    def printer(x,y):
        if x<=0 and y<=0:
            return
            
        if dp[x-1][y]+1 == dp[x][y] and x>0:
            print("DELETE "+str(x))
            printer(x-1,y)
        elif dp[x][y-1]+1 == dp[x][y] and y>0:
            print("INSERT "+ str(x+1)+" "+ str2[y-1])
            printer(x,y-1)
        else:
            if str1[x-1]!=str2[y-1]:
                print("REPLACE "+ str(x)+ " "+str2[y-1])
            printer(x-1,y-1)
    
    printer(len(str1), len(str2))
    return 


str1  = input()
str2 = input()
solution(str1, str2)
