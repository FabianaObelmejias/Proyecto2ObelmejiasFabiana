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
public class Cola {
    private Nodo cola;
    private Nodo cabeza;
    private int size;

    public Cola() {
        this.cola = this.cabeza = null;
        this.size = 0;
    }
    
    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return this.cabeza == null;
    }
    
    public void encolar(Object dato){
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){
            this.setCabeza(pNew);
            this.setCola(pNew);
        }else{
           this.cola.setpNext(pNew);
           this.setCola(pNew);
        }
        size++;
    }
    
    
    public Object desencolar(){
        if(!this.isEmpty()){
           Object eliminar = this.cabeza.getDato();
           this.setCabeza(this.cabeza.getpNext());
           return eliminar;
        }
        return null;
    }
    
    public void mostrar(){
        if(!this.isEmpty()){
            String listaString = "";
            
            Nodo temp = this.cabeza;
            while(temp != null){
                listaString += temp.getDato() + "\n";
                temp = temp.getpNext();
            }
            
            JOptionPane.showMessageDialog(null, listaString);
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
        }
    }
}
