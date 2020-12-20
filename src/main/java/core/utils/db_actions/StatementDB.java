package core.utils.db_actions;

import java.sql.SQLException;
import java.sql.Statement;


public class StatementDB {

    private static Statement statement = null;

    private StatementDB(){

    }

    public static Statement getInstance(){
        if(statement != null){
            return statement;
        }
        try {
            statement = ConnectToDB.getInstance().createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return statement;
    }
}