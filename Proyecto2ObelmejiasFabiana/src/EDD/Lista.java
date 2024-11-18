/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

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
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){
            this.setpFirst(pNew);
            
        }else{
            Nodo temp = this.pFirst;
            while(temp.getpNext() != null){
                temp = temp.getpNext();
            }
            
            temp.setpNext(pNew);
        }
        this.size ++;
    }
    
    public void eliminarFinal(){
        if(!this.isEmpty()){
            if(this.size == 1){
                this.destruir();
            }else{
                
            }
          
    }
}
    public void destruir(){ //vacía la lista por completo
        this.pFirst = null;
        this.size = 0; 
        
    }
}
