
def bubblesort(lista):
    troca = True
    while troca:
        troca = False
        for i in range(len(lista) - 1):
            if lista[i] > lista[ i+1]:
                trocar(lista, i)
                troca = True
    
    return lista

def trocar(listaa, indice):
    listaa[indice],listaa[indice + 1] = listaa[indice + 1] , listaa[indice]


a = [7,8,5,9,6,3,2,4,1,0]

b = [35,64,2]

print bubblesort(a)

print bubblesort(b)

