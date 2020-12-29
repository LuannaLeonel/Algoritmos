def insertionSort(array, index):
    if index <= 1:
        return

    insertionSort(array, index-1)

    tail = array[index-1]
    j = index -2

    while(j >= 0 and array[j] > tail):
        array[j+1] = array[j]
        j -= 1
    array[j+1] = tail

    

a = [5,6,7,1,2,8,4,3]
b = [1,1,1,1]
c = [0,0,0,0]
d = [9,8,7,6,5,4,3,2,1]

print a
(insertionSort(a,8))
print a

print b
(insertionSort(b,4))
print b

print c
insertionSort(c,4)
print c

print d
insertionSort(d,9)
print d

