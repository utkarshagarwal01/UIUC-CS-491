def kmp_preprocess(pattern):
    m = len(pattern)
    prefix = [0] * m
    j = 0
    i = 1
    while i < m:
        if pattern[i] == pattern[j]:
            j += 1
            prefix[i] = j
            i += 1
        else:
            if j != 0:
                j = prefix[j - 1]
            else:
                prefix[i] = 0
                i += 1
    return prefix


def count_occurrences(text, pattern):
    if len(pattern) == 0:
        return len(text) + 1

    prefix = kmp_preprocess(pattern)

    cnt = 0

    n = len(text)
    m = len(pattern)
    i, j = 0, 0
    while i < n:
        if pattern[j] == text[i]:
            i += 1
            j += 1
        if j == m:
            cnt += 1
            j = prefix[j - 1]
        elif i < n and pattern[j] != text[i]:
            if j != 0:
                j = prefix[j - 1]
            else:
                i += 1
    return cnt


num_elements, window_size = map(int, input().split())
elements_a = list(map(int, input().split()))
elements_b = list(map(int, input().split()))

text = [elements_a[i + 1] - elements_a[i] for i in range(num_elements - 1)]
pattern = [elements_b[i + 1] - elements_b[i] for i in range(window_size - 1)]

print(count_occurrences(text, pattern))
