/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 * Clase que proporciona métodos para validar y convertir cadenas numéricas.
 * 
 * Ofrece funcionalidad para verificar si una cadena contiene solo dígitos
 * y para convertirla a un número entero, devolviendo un valor especial si no es válida.
 * 
 * @author obelm
 */
public class Validar {

    /**
     * Método privado que verifica si una cadena contiene únicamente números.
     * Utiliza una expresión regular para la validación.
     * 
     * @param num la cadena a validar
     * @return true si la cadena contiene solo dígitos, false en caso contrario
     */
    private boolean validarnumeros(String num) {
        return num.matches("[0-9]*"); // Verifica si la cadena contiene solo dígitos (0-9)
    }

    /**
     * Valida una cadena para verificar si contiene solo números y la convierte a entero.
     * Si la cadena no es válida (no contiene solo números), retorna -1.
     * 
     * @param numero la cadena a validar y convertir
     * @return el número entero si la validación es exitosa, o -1 si no es válida
     */
    public int validarNumeros(String numero) {
        if (validarnumeros(numero)) {
            // La cadena es válida, convertir a entero
            return Integer.parseInt(numero);
        } else {
            // La cadena no es válida, devolver -1 como indicador
            return -1;
        }
    }
}

