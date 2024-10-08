package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private T[] _sec;

    private class Nodo {
        private T _ahead;
        private T _behind;
    }

    public ListaEnlazada() {
        _sec = (T[]) new Object[0];
    }

    public int longitud() {
        return _sec.length;
    }

    public void agregarAdelante(T elem) {
        T[] nueva_sec = (T[]) new Object[_sec.length + 1];
        nueva_sec[0] = elem;
        for (int i = 0; i < _sec.length; i++) {
            nueva_sec[i + 1] = _sec[i];
        }
        _sec = nueva_sec;
    }

    public void agregarAtras(T elem) {
        T[] nueva_sec = (T[]) new Object[_sec.length + 1];
        for (int i = 0; i < _sec.length; i++) {
            nueva_sec[i] = _sec[i];
        }
        nueva_sec[_sec.length] = elem;
        _sec = nueva_sec;
    }

    public T obtener(int i) {
        return _sec[i];
    }

    public void eliminar(int i) {
        T[] nueva_sec = (T[]) new Object[_sec.length - 1];
        for (int j = 0; j < i; j++) {
            nueva_sec[j] = _sec[j];
        }
        for (int j = i + 1; j < _sec.length; j++) {
            nueva_sec[j - 1] = _sec[i];
        }
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public boolean hayAnterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T anterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
