package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        // COMPLETAR
        return Math.sqrt(x*x+y*y);
    }

    boolean esPar(int n) {
        return n%2==0;
    }

    boolean esBisiesto(int n) {
        return (n%4==0 && (n%100!=0 || n%400==0));
    }

    int factorialIterativo(int n) {
        int res=1;
        while(n!=0) {
            res=res*n;
            n--;
        };
        return res;
    }

    int factorialRecursivo(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return factorialRecursivo(n-1)*n;
    }

    boolean esPrimo(int n) {
        int divisores=(int) Math.floor(Math.sqrt(n));
        if(n==1 || n==0){
            return false;
        }
        while(divisores!=1) {
            if(n%divisores==0) {
                return false;
            }
        divisores--;
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res=0;
        for(int n:numeros) {
            res=res+n;
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for(int i=0;i<numeros.length; i++){
            if(buscado==numeros[i]) {
                return i;
            }
        } return -1;
    }

    boolean tienePrimo(int[] numeros) {
        for(int n:numeros) {
            if(esPrimo(n)) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for(int n:numeros) {
            if(esPar(n)==false) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if(s2.length()<s1.length()) {
            return false;
        }
        for(int i=0; i<s1.length(); i++) {
            if(s2.charAt(i)!=s1.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    //Creo esta funcion para facilitar esSufijo
    String darVueltaString(String s1) {
        int finals1= s1.length() -1;
        String nuevo= new String() ;
        while(finals1!=-1) {
            nuevo=nuevo+ s1.charAt(finals1);
            finals1--;}
            return nuevo;
    }

    boolean esSufijo(String s1, String s2) {
        if(s2.length()<s1.length()) {
            return false;
        }
        return esPrefijo(darVueltaString(s1), darVueltaString(s2));
        
    }
}
