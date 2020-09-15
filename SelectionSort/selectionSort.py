
def selectionsort(lista):
    
    for i in range(len(lista) -1):
        imenor = i;
        for f in range(i+1,len(lista)):
            if lista[f] < lista[imenor]:
                imenor = f

        lista[i], lista[imenor] = lista[imenor], lista[i]
    return lista

a = [9,5,6,7,3,1]
b = [456,789,123]

print selectionsort(a)
print selectionsort(b)
