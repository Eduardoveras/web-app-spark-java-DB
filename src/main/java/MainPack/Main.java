package MainPack;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.get;
import static spark.Spark.post;

import org.omg.PortableInterceptor.INACTIVE;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import sun.java2d.loops.ProcessPath;


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
            createMainPage(conn);


        post("/add", (request, response) -> {

            String name = request.queryParams("firstname");
            String last = request.queryParams("lastname");
            String mat = request.queryParams("matricula");
            String tell = request.queryParams("phone");
            response.redirect("/add");
            System.out.println("matricula:"+mat);
            insertData(conn,Integer.valueOf(mat),name,last,tell);
            //System.out.println(foo+last);
            return name+last;
        });

        post("/edit/*", (request, response) -> {

            String name = request.queryParams("firstname");
            String last = request.queryParams("lastname");
            String mat = request.queryParams("matricula");
            String tell = request.queryParams("phone");
            editStudentData(conn, new Estudiante(Integer.parseInt(mat),name,last,tell));
            response.redirect("/");
            return name+last;
        });


        post("/", (request, response) -> {
            String formType = request.queryParams("kind");
            String mat = request.queryParams("matricula");
            System.out.println(formType);
            if (Objects.equals(formType, "erase"))
            {
                deleteFromTable(conn,mat.replace(",", ""));
                response.redirect("/");
            }
            if (Objects.equals(formType, "edit"))
                if (checkIfMatriculaExists(conn, Integer.parseInt(mat)))
                    response.redirect("/edit/" + mat.replace(",", ""));
                else
                    System.out.println("You are trying to delete a user that dosnt exists...you fool");
            return "exit";
        });
        //conn.close();

    }

    public static void createMainPage(Connection conn)
    {
        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            ArrayList<Estudiante> listaEst= selectFromTable(conn);
            attributes.put("message", "Welcome.");
            attributes.put("estudiantes",listaEst);
            return new ModelAndView(attributes, "homepage.ftl");

        }, new FreeMarkerEngine());

        get("/add", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "addStudents.ftl");
        }, new FreeMarkerEngine());

        get("/edit/:name", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Estudiante estud = getStudentData(conn,Integer.parseInt(request.params(":name")));
            attributes.put("matricula",request.params(":name"));
            attributes.put("nombre",estud.getNombre());
            attributes.put("apellido",estud.getApellido());
            attributes.put("telefono",estud.getTelefono());
            return new ModelAndView(attributes, "editStudentPage.ftl");
        }, new FreeMarkerEngine());



    }

    public static void editStudentData(Connection conn,Estudiante est) throws SQLException
    {
        Statement stmt = conn.createStatement();
        String sql = "UPDATE" +TABLE_NAME +
                "SET nombre='"+est.getNombre()+"',apellidos='"+est.getApellido()+"', telefono='"+est.getTelefono()+
                "' WHERE matricula = "+est.getMatricula();
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }


    public static boolean checkIfMatriculaExists(Connection conn,int matricula) throws SQLException {

        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE matricula="+matricula;
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next())
        {
            return true;
        }
        return false;
    }

    public static Estudiante getStudentData(Connection conn,int matricula) throws SQLException
    {
        Statement stmt = conn.createStatement();
        String sql = "SELECT matricula, nombre, apellidos, telefono FROM "+TABLE_NAME+" Where matricula = "+matricula;
        ResultSet rs = stmt.executeQuery(sql);
        Estudiante estud = null;

        while(rs.next()){
            Integer mat  = rs.getInt("matricula");
            String  Nombre = rs.getString("nombre");
            String apellid = rs.getString("apellidos");
            String telef = rs.getString("telefono");
            estud= new Estudiante(mat,Nombre,apellid,telef);
        }
        rs.close();
        return estud;
    }

    public static void deleteFromTable(Connection conn, String mat) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM" +TABLE_NAME +
                "WHERE matricula = "+mat;
        stmt.executeUpdate(sql);

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

    public static void insertData(Connection conn,int mat, String name, String lastName, String phone) throws  SQLException
    {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO "+TABLE_NAME+
                "VALUES ("+mat+", '"+name+"', '"+lastName+"',"+phone+")";
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
            System.out.println("mat="+mat+" Nom="+Nombre+" Apellido="+apellid+" tell="+telef);
        }
        rs.close();
        return listaEstudiantes;

    }
}
