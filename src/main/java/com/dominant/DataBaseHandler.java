package com.dominant;

import java.sql.*;

import static com.dominant.FinalVariable.*;


public class DataBaseHandler{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,DB_USERNAME,DB_PASSWORD);

        return dbConnection;
        }

    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE " + USERS_NAME + "=? AND " + USERS_PASSWORD + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1,user.getUser_name());
            preparedStatement.setString(2,user.getUser_password());

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
