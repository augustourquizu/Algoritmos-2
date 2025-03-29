package aed;

public class Horario {


    private int hora;
    private int minutos;

     public Horario(int hora_, int minutos_) {
        hora=hora_;
        minutos= minutos_;
    }

    public Horario(Horario horario_) {
        hora=horario_.hora();
        minutos=horario_.minutos();
    }
    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora+":"+minutos;
    }

    @Override
    public boolean equals(Object otro) {
        if(otro!=null && otro.getClass()==this.getClass() ){
            Horario otroHorario= (Horario) otro;
            return (otroHorario.minutos==this.minutos && otroHorario.hora==this.hora );
        }
        return false;
    }

}
