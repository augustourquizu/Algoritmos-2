package aed;

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] recordatorios;
    private int cantidad;
    public ArregloRedimensionableDeRecordatorios() {
        recordatorios=new Recordatorio[0];
        cantidad=0;
    }

    public int longitud() {

       return cantidad ;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] recordatorioNuevo=new Recordatorio[cantidad+1];
        for (int iterar = 0; iterar < cantidad; iterar++) {
            recordatorioNuevo[iterar] = recordatorios[iterar];
        }
        recordatorioNuevo[cantidad]= i;
        cantidad++;
        recordatorios=recordatorioNuevo;
    }

    public Recordatorio obtener(int i) {
        return recordatorios[i];
    }

    public void quitarAtras() {
        cantidad--;
        Recordatorio[] recordatorioNuevo=new Recordatorio[cantidad];
        for (int iterar = 0; iterar < cantidad; iterar++) {
            recordatorioNuevo[iterar] = recordatorios[iterar];
        }
        recordatorios=recordatorioNuevo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] nuevoRecordatorios=new Recordatorio[cantidad];
        for(int iterar=0;iterar<indice;iterar++){
            nuevoRecordatorios[iterar]=recordatorios[iterar];
        }
        nuevoRecordatorios[indice]=valor;
        for(int iterar=indice+1;iterar<cantidad;iterar++){
            nuevoRecordatorios[iterar]=recordatorios[iterar];
        }
        recordatorios=nuevoRecordatorios;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        cantidad=vector.longitud();
        recordatorios= new Recordatorio[vector.longitud()];
        for(int indice=0; indice<cantidad; indice++){
            Recordatorio original=vector.obtener(indice);
            recordatorios[indice]= new Recordatorio(original.mensaje(), original.fecha(), original.horario());
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia=new ArregloRedimensionableDeRecordatorios();
        for(int indice=0; indice<cantidad; indice++){
            copia.agregarAtras(recordatorios[indice]);
        }

        return copia ;
    }
}
