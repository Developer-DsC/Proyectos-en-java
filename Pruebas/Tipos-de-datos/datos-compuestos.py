
#Lista "Contiene varios tipos de datos dentro"

#Lista de puede modificar los datos que contiene
lista=["Dalton Cornejo","Edad: 20",True,1.80]
print(lista[0])

lista[0]="Sancocho"
print(lista[0])

#Tupla no se puede modificar los datos
tupla=["Dalton Cornejo","Edad: 20",True,1.80]

print(tupla)

print(lista)

#Creando conjunto (set) 1.No se puede mostrar elementos por indice[x], 2. No se puede repetir datos
conjuto={"Dalton Cornejo","Edad: 20",True,1.80,"Dalton Cornejo"}


#Creando un diccionario (dit) 1.Muestra datos por nombre asociado(nombre = Daltinho)
#Estructura: clave : valor "key:value"
diccionario={
    "nombre": "Daltinho",
    "Edad:":20,
    "Feliz:": False,
    "Altura": 1.80,
    "Dato duplicado" : "Daltinho"
}

print(diccionario["nombre"])
print(diccionario["Edad:"])
print(diccionario["Feliz:"])

