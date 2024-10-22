package aed;

import java.util.*;
import java.text.MessageFormat;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo fst;
    private Nodo lst;
    private int size;

    private class Nodo {
        private Nodo _next;
        private Nodo _former;
        private T _val;

        public Nodo(T val, Nodo next, Nodo former) {
            _next = next;
            _val = val;
            _former = former;
        }

        public T getValue() {
            return _val;
        }

        public Nodo getNext() {
            return _next;
        }

        public Nodo getFormer() {
            return _former;
        }

        public void setNext(Nodo elem) {
            _next = elem;
        }

        public void setFormer(Nodo elem) {
            _former = elem;
        }

        public void setValue(T elem) {
            _val = elem;
        }
    }

    public ListaEnlazada() {
        fst = null;
        lst = null;
        size = 0;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo addedNode = new Nodo(elem, fst, null);
        if (lst == null) {
            lst = addedNode;
        } else {
            fst.setFormer(addedNode);
        }
        fst = addedNode;
        size += 1;
    }

    public void agregarAtras(T elem) {
        Nodo addedNode = new Nodo(elem, null, lst);
        if (fst == null) {
            fst = addedNode;
        } else {
            lst.setNext(addedNode);
        }
        lst = addedNode;
        size += 1;
    }

    public T obtener(int i) {
        return obtenerNodo(i).getValue();
    }

    public Nodo obtenerNodo(int i) {
        Nodo iNodo = fst;
        for (int j = 0; j < i; j++) {
            iNodo = iNodo.getNext();
        }
        return iNodo;
    }

    public void eliminar(int i) {
        Nodo del = obtenerNodo(i);
        if (del != fst && del != lst) {
            del.getFormer().setNext(del.getNext());
        }
        if (del == fst) {
            fst = del.getNext();
        }
        if (del == lst) {
            lst = del.getNext();
        }
        size -= 1;
        del = null;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo cambiado = obtenerNodo(indice);
        cambiado.setValue(elem);
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> res = new ListaEnlazada<>();
        for (int i = 0; i < lista.longitud(); i++) {
            res.agregarAtras(lista.obtener(i));
        }
        fst = res.fst;
        lst = res.lst;
        size = res.size;
    }

    @Override
    public String toString() {
        String res = MessageFormat.format("[{0},", obtener(0));
        for (int i = 1; i < size - 1; i++) {
            res += MessageFormat.format(" {0},", obtener(i));
        }
        if (size > 1) {
            res += MessageFormat.format(" {0}]", obtener(size - 1));
        }
        return res;
    }

    private class ListaIterador implements Iterador<T> {
        private int pos;

        public boolean haySiguiente() {
            return pos < size;
        }

        public boolean hayAnterior() {
            return pos > 0;
        }

        public T siguiente() {
            T value = obtener(pos);
            pos += 1;
            return value;
        }

        public T anterior() {
            pos -= 1;
            T value = obtener(pos);
            return value;
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
