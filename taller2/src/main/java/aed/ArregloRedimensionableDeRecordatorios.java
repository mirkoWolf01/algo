package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] sec;

    public ArregloRedimensionableDeRecordatorios() {
        sec = new Recordatorio[0];
    }

    public int longitud() {
        return sec.length;
    }

    public void agregarAtras(Recordatorio i) {
        int new_size = sec.length + 1;
        Recordatorio[] nueva_sec = new Recordatorio[new_size];
        for (int pos = 0; pos < sec.length; pos++) {
            nueva_sec[pos] = sec[pos];
        }
        nueva_sec[new_size - 1] = i.copy();
        sec = nueva_sec;
    }

    public Recordatorio obtener(int i) {
        Recordatorio elemento = null;
        if (i >= 0 && i < sec.length) {
            elemento = sec[i].copy();
        }
        return elemento;
    }

    public void quitarAtras() {
        int new_size = sec.length - 1;
        Recordatorio[] nueva_sec = new Recordatorio[new_size];
        for (int pos = 0; pos < sec.length - 1; pos++) {
            nueva_sec[pos] = sec[pos];
        }
        sec = nueva_sec;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        sec[indice] = valor.copy();
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] new_sec = new Recordatorio[vector.longitud()];
        for (int i = 0; i < vector.longitud(); i++) {
            new_sec[i] = vector.obtener(i).copy();
        }
        sec = new_sec;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < sec.length; i++) {
            vector.agregarAtras(sec[i]);
        }
        return vector;
    }
}
