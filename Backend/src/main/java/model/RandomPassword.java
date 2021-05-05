/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model;

public class RandomPassword {
    
    private RandomPassword(){
        
    }
    
    public static RandomPassword getInstance(){
        if(instance == null){
            instance = new RandomPassword();
        }
        return instance;
    }
    
    public String generate(){
         String password = "";
         String aux = MAYUSCULAS + MINUSCULAS + NUMEROS + ESPECIALES;
         for(int i = 0; i < DEFAULT_LENGTH; i++){
             password += (aux.charAt((int)(Math.random() * aux.length())));
         }
         return password;
    }
    
    private static RandomPassword instance = null;
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnñopqrstuvwxyz";
    private static final String NUMEROS = "1234567890";
    private static final String ESPECIALES = "!.$&¡";
    private static final int DEFAULT_LENGTH = 4;
}
