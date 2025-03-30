package aed;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;
    public Agenda(Fecha fechaActual_) {
        fechaActual= new Fecha(fechaActual_);
        recordatorios=new ArregloRedimensionableDeRecordatorios();
    }
    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String notas=fechaActual.toString()+"\n=====\n";
        for(int indice=0;indice<recordatorios.longitud();indice++){
            if(fechaActual.equals(recordatorios.obtener(indice).fecha())){
                notas+=recordatorios.obtener(indice).toString()+"\n";
            }
        }
        return notas;
    }
    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return fechaActual;
    }

}
