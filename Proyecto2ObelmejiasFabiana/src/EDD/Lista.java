/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author obelm
 */
public class Lista {
    private Nodo pFirst;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
   
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    public void insertarFinal(Object dato){
        //Crear un nodo con el dato a insertar
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){
            //Como la lista es vacio pFirts sera pNew
           this.setpFirst(pNew);
        }else{
            //Iterar en la lista hasta llegar al ultimo
            Nodo temp = this.pFirst;
            //Sabre que llegue al ultimo cuando siguiente sea null
            while(temp.getpNext() != null){
                //temp ahora sera su siguiente
                temp = temp.getpNext();
            }
            //Cuando temp llegue al ultimo, le digo que su siguiente es pNew
            temp.setpNext(pNew);
        }
        this.size ++;
    }
    
    public void eliminarFinal(){
        if(!this.isEmpty()){
           if(this.size == 1){
               this.setpFirst(null);
           }else{
               Nodo temp = this.pFirst;
               while(temp.getpNext().getpNext() != null){
                   temp = temp.getpNext();
               }
               temp.setpNext(null);
           }
           size--;
        }
    }
    
    public boolean buscar(Object dato){
        if(!this.isEmpty()){
            if(this.size == 1){
                return this.pFirst.getDato() == dato;
            }else{
               Nodo temp = this.pFirst;
               while(temp != null){
                   if(temp.getDato() == dato){
                       return true;
                   }
                   temp = temp.getpNext();
               }
               return false;
            }
        } 
        return false;
    }
    
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getpNext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
   
    
    public void mostrar(){
        if(!this.isEmpty()){
            String listaString = "";
            
            Nodo temp = this.pFirst;
            while(temp != null){
                listaString += temp.getDato() + "\n";
                temp = temp.getpNext();
            }
            
            JOptionPane.showMessageDialog(null, listaString);
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
        }
    }
    
    public void destruir(){
       this.pFirst = null;
       this.size = 0;
    }
    
}
