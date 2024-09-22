package aed;

import java.text.MessageFormat;

public class Horario {
    private int _hora;
    private int _min;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _min = minutos;
    }

    public Horario(Horario horario) {
        _hora = horario.hora();
        _min = horario.minutos();
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _min;
    }

    @Override
    public String toString() {
        String m = String.valueOf(_min);
        String h = String.valueOf(_hora);

        if (_min < 10 && _min > 0) {
            m = MessageFormat.format("0{0}", _min);
        }
        return MessageFormat.format("{0}:{1}", h, m);
    }

    @Override
    public boolean equals(Object otro) {
        if (otro.getClass() != this.getClass() || otro == null) {
            return false;
        }
        Horario otroHorario = (Horario) otro;
        return (this.hora() == otroHorario.hora() && this.minutos() == otroHorario.minutos());
    }

}
