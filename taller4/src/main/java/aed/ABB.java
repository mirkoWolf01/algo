package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _len;

    private class Nodo {
        public Nodo left;
        public Nodo right;
        public T value;
        public Nodo father;

        public Nodo(T _val) {
            left = null;
            right = null;
            value = _val;
        }

        public Nodo(T _val, Nodo _father) {
            left = null;
            right = null;
            value = _val;
            father = _father;
        }

        public Nodo(T _val, Nodo _left, Nodo _right) {
            left = _left;
            value = _val;
            right = _right;
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

    public T maximo() {
        Nodo actual = _raiz;
        while (actual.right != null) {
            actual = actual.right;
        }
        return actual.value;
    }

    public void insertar(T elem) {
        if (!pertenece(elem)) {
            _len += 1;
        }
        if (_raiz == null) {
            _raiz = new Nodo(elem);
        } else {
            Nodo actual = _raiz;
            int diff = elem.compareTo(actual.value);
            while (diff != 0) {
                if (diff < 0) {
                    if (actual.left == null) {
                        actual.left = new Nodo(elem, actual);

                    }
                    actual = actual.left;
                }
                if (diff > 0) {
                    if (actual.right == null) {
                        actual.right = new Nodo(elem, actual);
                    }
                    actual = actual.right;
                }
                diff = elem.compareTo(actual.value);
            }
        }

    }

    public boolean pertenece(T elem) {
        boolean res = false;
        if (!isNull()) {
            if (getNodo(elem) != null) {
                res = true;
            }
        }
        return res;
    }

    public Nodo getNodo(T elem) {
        Nodo actual = _raiz;
        int diff = elem.compareTo(actual.value);
        while (diff != 0) {
            if (diff > 0 && actual.right != null) {
                actual = actual.right;
            } else if (diff < 0 && actual.left != null) {
                actual = actual.left;
            } else {
                return null;
            }
            diff = elem.compareTo(actual.value);
        }
        return actual;
    }

    public void eliminar(T elem) {
        if (pertenece(elem)) {
            Nodo del = getNodo(elem);
            if (del != _raiz) {
                int diff = elem.compareTo(del.father.value);
                if (del.left == null && del.right == null) {
                    if (diff > 0) {
                        del.father.right = null;
                    }
                    if (diff < 0) {
                        del.father.left = null;
                    }
                }

                else if (del.left != null && del.right == null) {
                    if (diff > 0) {
                        del.father.right = del.left;
                    }
                    if (diff < 0) {
                        del.father.left = del.left;
                    }
                } else if (del.left == null && del.right != null) {
                    if (diff > 0) {
                        del.father.right = del.right;
                    }
                    if (diff < 0) {
                        del.father.left = del.right;
                    }
                }

                else if (del.left != null && del.right != null) {
                    Nodo actual = del.right;
                    while (actual.left != null) {
                        actual = actual.left;
                    }
                    del.value = actual.value;
                    actual.father.left = actual.right;
                }
            } else {
                if (del.left == null && del.right == null) {
                    _raiz = null;
                } else if (del.right != null && del.left == null) {
                    _raiz = del.right;
                    _raiz.father = null;
                } else if (del.right == null && del.left != null) {
                    _raiz = del.left;
                    _raiz.father = null;
                } else if (del.right != null && del.right != null) {
                    Nodo actual = del.right;
                    while (actual.left != null) {
                        actual = actual.left;
                    }
                    del.value = actual.value;
                    actual.father.left = actual.right;
                }

            }

            _len -= 1;
        }
    }

    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void inorder() {

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
