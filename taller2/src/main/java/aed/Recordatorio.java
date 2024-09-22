package aed;

import java.text.MessageFormat;

public class Recordatorio {
    private String _msg;
    private Fecha _fecha;
    private Horario _horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _msg = mensaje;
        _fecha = new Fecha(fecha.dia(), fecha.mes());
        _horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return new Horario(_horario.hora(), _horario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(_fecha.dia(), _fecha.mes());
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
                otroRec.fecha() == this.fecha() &&
                otroRec.horario() == this.horario());
    }

}
