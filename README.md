# BST en Java - Guias 4 y 5 (Estructura de Datos II)

## Archivos
- NodoArbol.java : nodo generico con getters y setters (incluye setDato).
- ArbolBST.java  : insertar, buscar, minValor, eliminar, altura, inorden, esBST.
- Main.java      : pruebas de ejecucion de ambas guias.

## Como ejecutar
    javac *.java
    java Main

Requiere Java 11 o superior.

## Convencion
Menores a la izquierda, mayores o iguales a la derecha.

## Analisis O(log n) frente a O(n)
- Arbol balanceado (insercion aleatoria): la altura es cercana a log2(n),
  buscar e insertar cuestan O(log n).
- Arbol degenerado (insercion ordenada): cada nodo queda como hijo derecho
  del anterior, el arbol parece una lista enlazada, la altura es n y las
  operaciones cuestan O(n).
- Complete aqui la tabla con los resultados que imprime Main
  (altura y comparaciones de cada arbol).

## Eliminacion: referencias que cambian
1. Hoja: el padre apunta a null en lugar del nodo.
2. Un hijo: el padre apunta al unico hijo del nodo eliminado.
3. Dos hijos: el nodo conserva su posicion, su dato se reemplaza por el
   sucesor inorden (minimo del subarbol derecho) y luego se elimina ese
   sucesor del subarbol derecho (que sera hoja o tendra un solo hijo).
