/*
    Universidad Nacional de Costa Rica
    Escuela de Informática
    EIF209 Programación IV, ciclo I 2021
    Mauricio Gutiérrez Vásquez 118260119
    Adolfo Di Carlo Martínez Martínez 118050228
    Yeikol Villalobos Herrera 702670531
    Proyecto #1, Sistema web CursosLibres.com
*/

package model.dao;

import cr.ac.una.db.Database;
import java.io.IOException;
import java.io.InputStream;

public class DaoDB extends Database {

    public DaoDB() throws IOException {
        InputStream in = getClass().getResourceAsStream(DAO_CONFIGURATION_PATH);
        loadConfiguration(in);
    }
    
     protected static final String DAO_CONFIGURATION_PATH = "/model/dao/dao.properties";
}
