/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author obelm
 */
public class Validar {
    private boolean validarnumeros(String num){
        return num.matches("[0-9] *");
        
    }
    
    public int ValidarNumeros(String numero){
        if(validarnumeros(numero) == true){
            int num = Integer.parseInt(numero);
            return num;
        }else{
            return -1;
        }
    }
}