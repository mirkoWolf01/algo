package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _len;

    private class Nodo {
        public Nodo left, right;
        public T value;

        public Nodo(T _val) {
            left = right = null;
            value = _val;
        }
    }

    public ABB() {
        _raiz = null;
        _len = 0;
    }

    public boolean isNull() {
        return _raiz == null;
    }

    public int cardinal() {
        return _len;
    }

    public T minimo() {
        Nodo actual = _raiz;
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual.value;
    }

    private T minimo_desde(Nodo actual) {
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual.value;
    }

    public T maximo() {
        Nodo actual = _raiz;
        while (actual.right != null) {
            actual = actual.right;
        }
        return actual.value;
    }

    public void insertar(T elem) {
        if (!pertenece(elem)) {
            _raiz = insert_recursive(_raiz, elem);
            _len += 1;
        }
    }

    private Nodo insert_recursive(Nodo actual, T elem) {
        if (actual == null) {
            actual = new Nodo(elem);
        }
        int diff = elem.compareTo(actual.value);
        if (diff > 0) {
            actual.right = insert_recursive(actual.right, elem);
        } else if (diff < 0) {
            actual.left = insert_recursive(actual.left, elem);
        }
        return actual;
    }

    public boolean pertenece(T elem) {
        return pertenece_recursive(_raiz, elem);
    }

    private boolean pertenece_recursive(Nodo actual, T elem) {
        if (actual != null) {
            int diff = elem.compareTo(actual.value);
            if (diff == 0) {
                return true;
            }
            if (diff > 0) {
                return pertenece_recursive(actual.right, elem);
            }
            if (diff < 0) {
                return pertenece_recursive(actual.left, elem);
            }
        }
        return false;
    }

    public void eliminar(T elem) {
        _raiz = eliminar_recursive(_raiz, elem);
        _len -= 1;
    }

    private Nodo eliminar_recursive(Nodo actual, T elem) {
        if (actual == null) {
            return actual;
        }
        int diff = elem.compareTo(actual.value);
        if (diff > 0) {
            actual.right = eliminar_recursive(actual.right, elem);
        } else if (diff < 0) {
            actual.left = eliminar_recursive(actual.left, elem);
        } else {
            if (actual.left == null) {
                return actual.right;
            } else if (actual.right == null) {
                return actual.left;
            }

            actual.value = minimo_desde(actual.right);
            actual.right = eliminar_recursive(actual.right, actual.value);
        }
        return actual;
    }

    public String toString() {
        return "{" + to_String_recursive(_raiz) + "}";
    }

    private String to_String_recursive(Nodo actual) {
        String res = "";
        if (actual != null) {
            String str_izquierdo = to_String_recursive(actual.left);
            String str_valor = actual.value.toString();
            String str_derecho = to_String_recursive(actual.right);
            if (str_izquierdo != "") {
                str_izquierdo += ",";
            }
            if (str_derecho != "") {
                str_valor += ",";
            }
            res = str_izquierdo + str_valor + str_derecho;
        }
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
