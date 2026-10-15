import java.util.Arrays;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        guia4Ejercicios();
        guia4Comparacion();
        guia5Eliminacion();
    }

    // ---------- GUIA 4: ejercicios basicos ----------
    private static void guia4Ejercicios() {
        titulo("GUIA 4 - Ejercicio 1: insertar 50,30,70,20,40,60,80");
        ArbolBST bst = new ArbolBST();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) bst.insertar(v);

        bst.imprimirArbol();
        System.out.println("Inorden: " + bst.inorden());
        System.out.println("Altura : " + bst.altura());

        titulo("GUIA 4 - Ejercicio 2: busqueda con camino");
        System.out.println("Buscar 40 (existe)   : " + bst.buscarConCamino(40));
        System.out.println("Buscar 65 (no existe): " + bst.buscarConCamino(65));
    }

    private static void guia4Comparacion() {
        titulo("GUIA 4 - Comparacion: 15 codigos aleatorios vs ordenados");


        Random rnd = new Random(42);
        int[] codigos = new int[15];
        for (int i = 0; i < codigos.length; i++) {//cuenta iniciando desde i como un contador y .lenght cuenta los caracteres
            int c;
            boolean repetido;
            do {
                c = 100 + rnd.nextInt(900);
                repetido = false;
                for (int j = 0; j < i; j++) if (codigos[j] == c) repetido = true;
            } while (repetido);
            codigos[i] = c;
        }

        int[] ordenados = codigos.clone();
        Arrays.sort(ordenados);

        // cinco busquedas: se usan los mismos codigos en ambos arboles
        int[] busquedas = {codigos[0], codigos[4], codigos[8], codigos[11], codigos[14]};

        ArbolBST aleatorio = new ArbolBST();
        for (int c : codigos) aleatorio.insertar(c);

        ArbolBST ordenado = new ArbolBST();
        for (int c : ordenados) ordenado.insertar(c);

        System.out.println("Orden aleatorio: " + Arrays.toString(codigos));
        aleatorio.imprimirArbol();
        System.out.println();
        System.out.println("Orden ascendente: " + Arrays.toString(ordenados));
        ordenado.imprimirArbol();

        System.out.println();
        System.out.printf("%-10s %-22s %-22s%n", "Codigo", "Comparaciones (alea)", "Comparaciones (ord)");//imprime el encabezado 
        int totalA = 0, totalO = 0;
        
        for (int b : busquedas) {
            aleatorio.buscar(b);
            int ca = aleatorio.getComparaciones();
            ordenado.buscar(b);
            int co = ordenado.getComparaciones();
            totalA += ca;
            totalO += co;
            System.out.printf("%-10d %-22d %-22d%n", b, ca, co);
        }
        System.out.printf("%-10s %-22d %-22d%n", "TOTAL", totalA, totalO);
        System.out.println();
        System.out.println("Altura aleatorio: " + aleatorio.altura() + "  (esBST: " + aleatorio.esBST() + ")");
        System.out.println("Altura ordenado : " + ordenado.altura() + "  (esBST: " + ordenado.esBST() + ")");
    }

    private static void guia5Eliminacion() {
        titulo("GUIA 5 - Prueba 1: eliminar nodo HOJA (20)");
        ArbolBST t1 = arbolBase();
        probarEliminacion(t1, 20);

        titulo("GUIA 5 - Prueba 2: eliminar nodo con UN HIJO (60, tiene a 65)");
        ArbolBST t2 = arbolBase();
        t2.insertar(65); // 60 queda con un solo hijo derecho
        probarEliminacion(t2, 60);

        titulo("GUIA 5 - Prueba 3: eliminar nodo con DOS HIJOS (30)");
        ArbolBST t3 = arbolBase();
        probarEliminacion(t3, 30);

        titulo("GUIA 5 - Prueba 4: eliminar la RAIZ (50)");
        ArbolBST t4 = arbolBase();
        probarEliminacion(t4, 50);

        titulo("GUIA 5 - Prueba 5: eliminar valor inexistente (99)");
        ArbolBST t5 = arbolBase();
        probarEliminacion(t5, 99);
    }

    private static ArbolBST arbolBase() {
        ArbolBST t = new ArbolBST();
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) t.insertar(v);
        return t;
    }

    private static void probarEliminacion(ArbolBST t, int valor) {
        System.out.println("ANTES:");
        t.imprimirArbol();
        System.out.println("Inorden: " + t.inorden());

        t.eliminar(valor);

        System.out.println("DESPUES de eliminar " + valor + ":");
        t.imprimirArbol();
        System.out.println("Inorden: " + t.inorden());
        System.out.println("Sigue siendo BST: " + t.esBST());
        System.out.println("Existe " + valor + " ahora: " + t.buscar(valor));
    }

    private static void titulo(String s) {
        System.out.println();
        System.out.println("==== " + s + " ====");
    }
}
