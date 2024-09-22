package aed;

import java.text.MessageFormat;

public class Agenda {
    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios sec_recor;

    public Agenda(Fecha fechaActual) {
        _fecha = new Fecha(fechaActual);
        sec_recor = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        sec_recor.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String fecha_txt = _fecha.toString();
        String recordatorios_txt = "";
        for (int i = 0; i < sec_recor.longitud(); i++) {
            if (sec_recor.obtener(i).fecha().equals(_fecha)) {
                recordatorios_txt = MessageFormat.format(
                        "{0}{1}\n",
                        recordatorios_txt,
                        sec_recor.obtener(i).toString());
            }
        }
        return MessageFormat.format("{0}\n{1}\n{2}", fecha_txt, "=====", recordatorios_txt);
    }

    public void incrementarDia() {
        _fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(_fecha);
    }

}
