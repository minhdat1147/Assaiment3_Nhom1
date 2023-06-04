package fa.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Conetion {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:60/sms";
//    static final String USER ="root";
//    static final String PASSWORD = "";
//    private Connection connection;
//    public JDBC_Conetion(){
//        this.init();
//    }
//    private void init(){
//        try{
//            Class.forName(JDBC_DRIVER);
//            System.out.println("connecting to database...");
//            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
//            System.out.println("Database connected");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
public static Connection getConnection() {
    try {
        //2 Load driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3. DriverManager => Connection (host. port. username / password)
        String url = "jdbc:mysql://localhost:60/sms";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);

//            System.out.println("Connect successful!!");

        return conn;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

}
