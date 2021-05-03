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
