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
        return actual.izq;
    }

    public T maximo(){
        Nodo actual=raiz;
        while(actual.der!=null){
            actual=actual.der;
        }
        return actual.der;
    }

    public void insertar(T elem){
        if(raiz==null){
            raiz= new Nodo(elem);
        }
        else if(actual.valor!=elem){
            if(elem.compareTo(actual.valor)<0 && actual.izq!=null){
                actual=actual.izq;
                insertar(elem);
            }
            else if(elem.compareTo(actual.valor)<0 && actual.izq==null) {
                actual.izq=elem;
                actual=raiz;
            }
            else if(elem.compareTo(actual.valor)>0 && actual.der!=null){
                actual=actual.der;
                insertar(elem);
            }
            else {
                actual.der=elem;
                actual=raiz;
            }

        }
        else{actual=raiz;}
    }

    public boolean pertenece(T elem){
        if(raiz==null){
            return false;
        }
        else if(actual.valor!=elem){
            if(elem.compareTo(actual.valor)<0 && actual.izq!=null){
                actual=actual.izq;
                petenece(elem);
            }
            else if(elem.compareTo(actual.valor)<0 && actual.izq==null) {
                actual=raiz;
                return false;
            }
            else if(elem.compareTo(actual.valor)>0 && actual.der!=null){
                actual=actual.der;
                pertenece(elem);
            }
            else {
                actual=raiz;
                return false;
            }

        }
        else{
            actual=raiz;
            return true;
        }
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
