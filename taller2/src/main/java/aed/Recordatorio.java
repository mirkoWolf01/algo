package aed;

import java.text.MessageFormat;

public class Recordatorio {
    private String _msg;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _msg = mensaje;
        _fecha = new Fecha(fecha);
        _horario = new Horario(horario);
    }

    public Horario horario() {
        return new Horario(_horario);
    }

    public Fecha fecha() {
        return new Fecha(_fecha);
    }

    public String mensaje() {
        return _msg;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} @ {1} {2}", _msg, _fecha, _horario.toString());
    }

    @Override
    public boolean equals(Object otro) {
        if (otro.getClass() != this.getClass() || otro == null) {
            return false;
        }
        Recordatorio otroRec = (Recordatorio) otro;

        return (otroRec.mensaje() == this.mensaje() &&
                this.fecha().equals(otroRec.fecha()) &&
                this.horario().equals(otroRec.horario()));
    }

    public Recordatorio copy() {
        Recordatorio copia = new Recordatorio(_msg, new Fecha(_fecha), new Horario(_horario));
        return copia;
    }

}
