package MainPack;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

import spark.ModelAndView;
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


    public static void main(String[] args) throws Exception{

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            // The hello.ftl file is located in directory:
            // src/test/resources/spark/template/freemarker
            return new ModelAndView(attributes, "hello.ftl");
        }, new FreeMarkerEngine());



            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            createBasicTable(conn);
            //insertData(conn);
            selectFromTable(conn);
            conn.close();

    }




    public static void createBasicTable(Connection conn) throws SQLException {
        System.out.println("Creating table in given database...");
        Statement stmt = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";

        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
    }

    public static void insertData(Connection conn) throws  SQLException
    {
        System.out.println("Inserting records into the table...");
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO Registration " +
                "VALUES (100, 'Zara', 'Ali', 18)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Registration " +
                "VALUES (101, 'Mahnaz', 'Fatma', 25)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Registration " +
                "VALUES (102, 'Zaid', 'Khan', 30)";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Registration " +
                "VALUES(103, 'Sumit', 'Mittal', 28)";
        stmt.executeUpdate(sql);
        System.out.println("Inserted records into the table...");
    }

    public static void selectFromTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT id, first, last, age FROM Registration";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }
        rs.close();
    }
}
