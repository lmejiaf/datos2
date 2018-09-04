/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author luis
 */
public class Aux {

    static Nodo raiz;

    static Nodo insertar(Nodo raiz, int clave) {
        if (raiz != null) {
            if (raiz.getClave() > clave) {
                raiz.setIzquierdo(insertar(raiz.getIzquierdo(), clave));
            } else if (raiz.getClave() < clave) {
                raiz.setIzquierdo(insertar(raiz.getDerecho(), clave));
            }
        } else {
            raiz = new Nodo(clave);
        }
        return raiz;
    }

    static void recorrerPorNiveles(Nodo raiz) {
        Queue<Nodo> cola = new LinkedList();
        cola.add(raiz);
        Nodo n;
        int i = 0;
        while (!cola.isEmpty()) {

            n = cola.poll();
            //accion, la que sea
            System.out.println(n.getClave() + ", nivel: " + i);
            //fin accion
            if (n.getIzquierdo() != null) {
                i++;
                cola.add(n.getIzquierdo());
            }
            if (n.getDerecho() != null) {
                i++;
                cola.add(n.getDerecho());
            }

        }
    }

    public static void main(String[] args) {
        raiz = insertar(raiz, 5);
        raiz = insertar(raiz, 4);
        raiz = insertar(raiz, 6);
        raiz = insertar(raiz, 8);
        raiz = insertar(raiz, 7);
        raiz = insertar(raiz, 3);
        raiz = insertar(raiz, 2);
        recorrerPorNiveles(raiz);

    }
}
