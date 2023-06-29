package org.example;

import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class Aerolineas {

    @Test
    public void testConexionBaseDatos () throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:msql//localhost:3306/master","usuario","password");
        assertFalse(connection.isClosed());
        connection.close();

    }

    @Test
    public void testServicioWeb(){
        try {
            URL url = new URL("");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


        }catch (Exception ex){

        }
    }

}
