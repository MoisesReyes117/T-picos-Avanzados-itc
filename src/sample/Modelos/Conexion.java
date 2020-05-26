package sample.Modelos;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String host = "localhost";
    private static final String user = "topicos20";
    private static final String pswd = "1234";
    private static final String db = "otso";
    public static Connection con;

    public static void CrearConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estamos abriendo el socket hacia el SGBD
            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",user,pswd);
        } catch (Exception e) {
            System.out.println("Error de conexion");
           e.printStackTrace();
        }
    }
}
