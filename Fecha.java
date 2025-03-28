package aed;

public class Fecha {
    private int dia;
    private int mes;
    
    public Fecha(int dia_, int mes_) {
        dia=dia_;
        mes=mes_;
    }

    public Fecha(Fecha fecha_) {
        dia = fecha_.dia();
        mes=fecha_.mes();
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }


    @Override
    public String toString() {
        String fecha= dia+"/"+mes;
        return fecha;
    }

    @Override
    public boolean equals(Object otra) {
        if(otra.getClass()==this.getClass()){
            Fecha otraFecha= (Fecha) otra;
            return (otraFecha.dia==this.dia && otraFecha.mes==this.mes);
        }
        
            
        return false;
    }


    public void incrementarDia() {
        dia++;
        if(dia>diasEnMes(mes)) {
            dia=dia-diasEnMes(mes);
            mes++;
        }
        if(mes>12){
            mes=1;
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
