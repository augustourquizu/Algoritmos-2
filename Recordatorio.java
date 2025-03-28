package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;
    public Recordatorio(String mensaje_, Fecha fecha_, Horario horario_) {
        mensaje=mensaje_;
        fecha= new Fecha(fecha_);
        horario= new Horario(horario_);
    }

    public Horario horario() {
        return new Horario(horario);
    }

    public Fecha fecha() {
        return new Fecha(fecha);
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        // Implementar
        return mensaje+" @ "+fecha.toString()+ " "+horario.toString();
    }


    @Override
    public boolean equals(Object otro) {
        if(otro.getClass()==this.getClass()){
            Recordatorio otroNuevo= (Recordatorio) otro;
            if(otroNuevo.fecha.equals(this.fecha) && otroNuevo.horario.equals(this.horario) && "mensaje".equals("mensaje")){
                return true;
            }
        }
        return false;
    }

}
