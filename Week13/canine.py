num_cases = int(input())

for case in range(num_cases):
    string = input()
    characters = list(string)
    num_changes = 0
    n = len(string)
    
    for i in range(1, n):
        if (i - 1 >= 0 and characters[i] == characters[i - 1]) or \
           (i - 2 >= 0 and characters[i] == characters[i - 2]):
            characters[i] = '*'
            num_changes += 1
            
    print(num_changes)