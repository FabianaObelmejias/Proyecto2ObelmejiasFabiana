/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author obelm
 */
public class ArbolGeneral {
   //solamenta va a tener la raiz 
    private NodoArbol raiz;

    public ArbolGeneral() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public boolean isEmpty(){
        return this.raiz == null;
    }
    
    public NodoArbol crearRaiz(Object dato){//primero creo la raiz y despues le agrego los hijos
        this.raiz = new NodoArbol(dato);
        return this.raiz;
        
    }
    
    public NodoArbol agregarHijo(NodoArbol padre, Object dato){
        NodoArbol hijo = new NodoArbol(dato);
        padre.agregarHijo(hijo);
        return hijo;
    }
    
    
    
    
    
    
}
