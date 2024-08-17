package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return ((n % 2) == 0);
    }

    boolean esBisiesto(int n) {
        // 4 divide a n y 100 no divide a n o 400 divide a n
        return (((n % 4) == 0) && !((n % 100) == 0)) || ((n % 400) == 0);
    }

    int factorialIterativo(int n) {
        int res = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n > 0) {
            res = n * factorialIterativo(n - 1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        boolean res = !(n < 2);
        for (int i = 2; i < n; i++) {
            if (res) {
                res = !((n % i) == 0);
            }
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < numeros.length; i++) {
            if (!esPar(numeros[i])) {
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = (s1.length() <= s2.length());
        if (res) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.toCharArray()[i] != s2.toCharArray()[i]) {
                    res = false;
                }
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = (s1.length() <= s2.length());
        if (res) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.toCharArray()[s1.length() - i - 1] != s2.toCharArray()[s2.length() - i - 1]) {
                    res = false;
                }
            }
        }
        return res;
    }
}