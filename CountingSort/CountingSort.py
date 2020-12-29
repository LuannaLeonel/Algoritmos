def counting_sort(array_A, max_value):
    
    maior = max_value + 1
    count = [0] * maior
    
    #ocorrencias
    for a in array_A:
        count[a] += 1

    i = 0
    for a in range(maior):
        for c in range(count[a]):
            array_A[i] = a
            i += 1

    return array_A

print(counting_sort( [2,1,5,8,1,2,5,3,1],8))

