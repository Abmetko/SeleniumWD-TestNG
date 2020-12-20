package core.utils.db_actions;

import java.sql.*;


public class ConnectToDB {

    /** JDBC URL, username and password of MySQL server **/
    private static final String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    /** JDBC variables for opening and managing connection **/
    private static Connection connection = null;

    private ConnectToDB(){

    }

    public static Connection getInstance(){
        if(connection != null){
            return connection;
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}