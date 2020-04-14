package com.disponibilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conect1;
    public Connection conexion() throws SQLException {

            Connection conect1 = DriverManager.getConnection("jdbc:mysql://localhost/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "darianna_loveyou@live.com", "Carreon863");
            System.out.println("conect"+conect1);



        return conect1;
    }


}
