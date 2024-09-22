package aed;

import java.text.MessageFormat;

public class Fecha {
    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        _dia = dia;
        _mes = mes;
    }

    public Fecha(Fecha fecha) {
        _dia = fecha.dia();
        _mes = fecha.mes();
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
        return _mes;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}/{1}", _dia, _mes);
    }

    @Override
    public boolean equals(Object otra) {
        if (otra.getClass() != this.getClass() || otra == null) {
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        return (this.dia() == otraFecha.dia() && this.mes() == otraFecha.mes());
    }

    public void incrementarDia() {
        if (diasEnMes(_mes) > _dia) {
            _dia++;
        } else {
            _dia = 1;
            if (_mes != 12) {
                _mes++;
            } else {
                _mes = 1;
            }
        }

    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }
}
