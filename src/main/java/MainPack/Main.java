package MainPack;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;


/**
 * Created by Eduardo veras on 25-May-16.
 *
 */
public class Main {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    private static final String TABLE_NAME= " estudiantes ";


    public static void main(String[] args) throws Exception{
        Spark.staticFileLocation("/public");




            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            createBasicTable(conn);
            //insertData(conn);
            ArrayList<Estudiante> listaEst= selectFromTable(conn);
            conn.close();
            createMainPage(listaEst);

    }

    public static void createMainPage(ArrayList<Estudiante> listaEst)
    {
        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            attributes.put("estudiantes",listaEst);
            return new ModelAndView(attributes, "homepage.ftl");

        }, new FreeMarkerEngine());

        get("/add", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            attributes.put("estudiantes",listaEst);
            return new ModelAndView(attributes, "addStudents.ftl");
        }, new FreeMarkerEngine());



    }




    public static void createBasicTable(Connection conn) throws SQLException {
        System.out.println("Creating table in given database...");
        Statement stmt = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"( " +
                "matricula INTEGER NOT NULL, " +
                "nombre varchar(100) NOT NULL,  " +
                "apellidos varchar(100) NOT NULL, " +
                "telefono varchar(50) NOT NULL, " +
                "PRIMARY KEY (matricula))";

        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
    }

    public static void insertData(Connection conn) throws  SQLException
    {
        System.out.println("Inserting records into the table...");
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO "+TABLE_NAME+
                "VALUES (100, 'Zara', 'Ali', 8093333333)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO "+TABLE_NAME+
                "VALUES (101, 'Mahnaz', 'Fatma', 8093333334)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO "+TABLE_NAME+
                "VALUES (102, 'Zaid', 'Khan', 8093333335)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO "+TABLE_NAME+
                "VALUES(103, 'Sumit', 'Mittal', 8093333336)";
        stmt.executeUpdate(sql);
        System.out.println("Se inserto data en la tabla...");
    }

    public static ArrayList selectFromTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT matricula, nombre, apellidos, telefono FROM "+TABLE_NAME;
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
        while(rs.next()){
            Integer mat  = rs.getInt("matricula");
            String  Nombre = rs.getString("nombre");
            String apellid = rs.getString("apellidos");
            String telef = rs.getString("telefono");
            listaEstudiantes.add(new Estudiante(mat,Nombre,apellid,telef));
        }
        rs.close();
        return listaEstudiantes;

    }
}
