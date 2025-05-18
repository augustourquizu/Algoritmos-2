package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz, actual;
    private int cardinal;

    private class Nodo {
       T valor;
       Nodo izq;
       Nodo der;
       Nodo padre;
       Nodo(T v) {valor= v;}
       
       
    }


    public ABB() {
        raiz= null;
        cardinal=0;
        actual=raiz;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo actual=raiz;
        while(actual.izq!=null){
            actual=actual.izq;
        }
        T valor=actual.valor;
        actual=raiz;
        return valor;
    }

    public T maximo(){
        while(actual.der!=null){
            actual=actual.der;
        }
        T valor=actual.valor;
        actual=raiz;
        return  valor;
    }
    private void insertar_(T elem){
        if(raiz==null){
            raiz= new Nodo(elem);
            cardinal++;
        }
        else if(!elem.equals(actual.valor)){
            if(elem.compareTo(actual.valor)<0 && actual.izq!=null){
                actual=actual.izq;
                insertar(elem);
            }
            else if(elem.compareTo(actual.valor)<0 && actual.izq==null) {
                actual.izq=new Nodo(elem);
                actual.izq.padre=actual;
                cardinal++;
            }
            else if(elem.compareTo(actual.valor)>0 && actual.der!=null){
                actual=actual.der;
                insertar(elem);
            }
            else {
                actual.der= new Nodo(elem);
                actual.der.padre=actual;
                cardinal++;
            }

        }
        else{actual=raiz;}
    }

    public void insertar(T elem){
        insertar_(elem);
        actual=raiz;
    }

    private boolean pertenece_(T elem){
        if (elem == null){return false;}
        if(raiz==null){
            return false;
        }
        else if(!elem.equals(actual.valor)){
            int comparo=elem.compareTo(actual.valor);
            if(comparo<0 && actual.izq!=null){
                actual=actual.izq;
                return pertenece(elem);
            }
            else if(comparo>0 && actual.der!=null){
                actual=actual.der;
                return pertenece(elem);
            }
            else{return false;}

        }
        else{return true;}
    }

    public boolean pertenece(T elem){
       boolean res=pertenece_(elem);
       actual=raiz;
       return res;
    }
    private void eliminar_(T elem){
        if(!elem.equals(actual.valor)){
            int comparo=elem.compareTo(actual.valor);
            if(comparo<0 && actual.izq!=null){
                actual=actual.izq;
                eliminar_(elem);
            }
            else if(comparo>0 && actual.der!=null){
                actual=actual.der;
                eliminar_(elem);
            }
        }
        else if(elem!=null){
            if(actual.der!=null && actual.izq!=null){
                Nodo copia=actual.der;
                while(copia.izq!=null){
                    copia=copia.izq;
                }
                actual.valor=copia.valor;
                if(copia.padre==actual){
                    actual.der=copia.der;
                    if(copia.der!=null){
                        copia.der.padre=copia.padre;}
                }
                else{if (copia.der!=null){
                    copia.der.padre=copia.padre;}
                    copia.padre.izq=copia.der;}
                }

            else if(actual.der!=null){
            if(actual!=raiz){
                if(actual.padre.izq==actual){
                    actual.der.padre=actual.padre;
                    actual.padre.izq=actual.der;
                }
                else{
                    actual.der.padre=actual.padre;
                    actual.padre.der=actual.der;
                }}
            else{raiz=raiz.der;
                raiz.padre=null;}
            }
            else if(actual.izq!=null){
                if(actual!=raiz){
                if(actual.valor.compareTo(actual.padre.valor)<0){
                    actual.izq.padre=actual.padre;
                    actual.padre.izq=actual.izq;
                }
                else{
                actual.izq.padre=actual.padre;
                actual.padre.der=actual.izq;
                }}
                else{raiz=raiz.izq;
                raiz.padre=null;}
            }
            else{
                if(actual!=raiz){
                    if(actual.padre.izq==actual){actual.padre.izq=null;}
                    else{actual.padre.der=null;}}
                else{raiz=null;}}
        cardinal--;
        }}
    public void eliminar(T elem){
        eliminar_(elem);
        actual=raiz;
    }

        private String inorden(Nodo actual, String s){
            if(actual!=null){
                s=inorden(actual.izq,s);
                if(!actual.valor.equals(minimo())){
                s=s+","+actual.valor.toString();}
                s=inorden(actual.der, s);
            }            
        return s;
        }

    public String toString(){
        String s="{";
        if(raiz!=null){
            s=s+minimo().toString();
        }
            s=inorden(actual, s);
        s=s+"}";
        actual=raiz;
        return s;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo copia;

        private void inorden(Nodo actual){
            if(actual!=null){
                inorden(actual.izq);
                if(!actual.valor.equals(minimo())){
                copia.der=new Nodo(actual.valor);
                copia=copia.der;}
                inorden(actual.der);
                
            }
        actual=raiz;
        }

        public ABB_Iterador(){
           copia=new Nodo(minimo());
           Nodo primero=copia;
           inorden(actual);
           copia.der=new Nodo(null);
           copia=primero;
        }

        public boolean haySiguiente() {            
            if(copia!=null && copia.der!=null){return true;}
            else{return false;}
        }
    
        public T siguiente() {
            T valor=copia.valor;
            copia=copia.der;
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
