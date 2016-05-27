package MainPack;

import spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;

import static spark.Spark.get;

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
        get("/hello", (req, res) -> "<h1>Hello World</h1>");

    }
}
