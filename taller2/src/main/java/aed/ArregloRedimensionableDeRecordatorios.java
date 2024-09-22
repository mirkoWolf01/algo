package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] sec;

    public ArregloRedimensionableDeRecordatorios() {

    }

    public int longitud() {
        return sec.length;
    }

    public void agregarAtras(Recordatorio i) {
        new Recordatorio(i.mensaje(), i.fecha(), i.horario());
    }

    public Recordatorio obtener(int i) {
        // Implementar
        return null;
    }

    public void quitarAtras() {
        // Implementar
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // Implementar
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        // Implementar
        return null;
    }
}
