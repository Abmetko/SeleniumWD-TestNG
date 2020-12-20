package core.utils.db_actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBManager {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public DBManager(Connection connection, Statement statement){
        DBManager.statement = statement;
        DBManager.connection = connection;
    }

    public void insertData() {
        String query = "INSERT INTO users.customers (id, name) VALUES (4, 'Paul');";
        try {
            statement.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) { /* can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /* can't do anything */ }
        }
    }

    public void selectData() {
        String query = "select id, name from customers";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + " " + name);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) { /* can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /* can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /* can't do anything */ }
        }
    }

    public void selectData(String element) {
        String query = "select " + element + " from customers";
        ArrayList<String> names = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                names.add(resultSet.getString(1));
            }
            System.out.println(names.get(0));
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) { /* can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /* can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /* can't do anything */ }
        }
    }

    public static void main(String[] args) {
        DBManager dbManager = new DBManager(ConnectToDB.getInstance(),StatementDB.getInstance());
        dbManager.selectData();
    }
}