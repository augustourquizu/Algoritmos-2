package aed;


import java.util.*;


public class ListaEnlazada<T> implements Secuencia<T> {
   // Completar atributos privados
   private Nodo primero;
   private Nodo ultimo;
   private int longitud;

   private class Nodo {
       T valor;
       Nodo sig;
       Nodo ant;
       Nodo(T v) {valor= v;}
       
       
    }


   public ListaEnlazada() {
       primero=null;
       ultimo=null;
       longitud=0;
   }


   public int longitud() {
       return longitud;
   }


   public void agregarAdelante(T elem) {
       Nodo nuevo = new Nodo(elem);
       if(primero==null){
           primero=nuevo;
           ultimo=nuevo;
       }   
       else{
           nuevo.sig=primero;
           primero.ant=nuevo;
           primero=nuevo; 
       }
       longitud++;
       }
      


   public void agregarAtras(T elem) {
       Nodo nuevo = new Nodo(elem);
       if(primero==null){
           primero=nuevo;
           ultimo=nuevo;
       }   
       else{
        nuevo.ant = ultimo;
        ultimo.sig = nuevo;
        ultimo = nuevo;
       }
       longitud++;
       }


   public T obtener(int i) {
       Nodo actual=primero;
       while(i>0){
        actual=actual.sig ;
        i--;}
        return actual.valor;
   }


   public void eliminar(int i) {
       Nodo actual=primero ;
       while(i>0){
        actual=actual.sig ;
        i--;
       }
       if(actual.ant==null){primero=actual.sig;}
       else{actual.ant.sig=actual.sig;}
       if(actual.sig!=null){actual.sig.ant=actual.ant;} 
       else{ultimo=actual.ant;}
       longitud--;
       
   }


   public void modificarPosicion(int indice, T elem) {

       while(indice>0){
        Nodo actual=primero;
        while(indice>0){
        actual=actual.sig;
        indice--;}
        actual.valor=elem;
       }
   }


   public ListaEnlazada(ListaEnlazada<T> lista) {
        if(lista.longitud()==0){
            primero=null;
            ultimo=null;
            longitud=0;
        }
        else{
            int indice=1;
            primero=new Nodo(lista.obtener(0));
            longitud++;
            Nodo actual=primero;
            while(indice<lista.longitud()){
                actual.sig= new Nodo(lista.obtener(indice));
                actual.sig.ant=actual;
                actual=actual.sig;
                longitud++;
                indice++;
            }
            ultimo=actual;
        }

   }
  
   @Override
   public String toString() {
       int i=0;
      String str="";
       while(i<longitud-1){
        str=str+ String.valueOf(this.obtener(i))+", ";
        i++;
       }
       str="["+str; 
       str=str+ String.valueOf(this.obtener(longitud-1)) + "]";
       return str;
   }


   private class ListaIterador implements Iterador<T> {
        Nodo iterador;

        public ListaIterador() {
            Nodo actual=primero;
            if(actual!=null){
            iterador=new Nodo (actual.valor);
            Nodo inicio=iterador;
            actual=actual.sig;
            while(actual!=null){
                iterador.sig= new Nodo(actual.valor);
                iterador.sig.ant=iterador;
                iterador=iterador.sig;  
                actual=actual.sig;
            }
            iterador.sig= new Nodo(null);
            iterador.sig.ant=iterador;
            iterador=inicio;}
        else{iterador=null;}

        }
       public boolean haySiguiente() {
           return (iterador!=null && iterador.sig!=null );
       }
      
       public boolean hayAnterior() {
        return (iterador!=null && iterador.ant!=null );
       }


       public T siguiente() {
            T v= iterador.valor;
           iterador=iterador.sig;
           return v;
       }
      


       public T anterior() {
        T v=iterador.ant.valor;
        iterador=iterador.ant;
        return v;
       }
   }


   public Iterador<T> iterador() {
    return new ListaIterador();
   }


}
