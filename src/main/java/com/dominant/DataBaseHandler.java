package com.dominant;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        String select = "SELECT * FROM " + TABLE_NAME_LOGIN + " WHERE " + USERS_NAME + "=? AND " + USERS_PASSWORD + "=?";

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

    public ObservableList<Info> getInfo(){
        ObservableList<Info> list= FXCollections.observableArrayList();
        String select = "SELECT * FROM " + TABLE_NAME_INFO;
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(new Info(Integer.parseInt(resultSet.getString(INFO_ID)), resultSet.getString(INFO_NAME),
                        Integer.parseInt(resultSet.getString(INFO_PAYMENT)), Integer.parseInt(resultSet.getString(INFO_SUM)),
                        resultSet.getString(INFO_TIME), resultSet.getString(INFO_ADDRESS),Integer.parseInt(resultSet.getString(INFO_PROFIT)),
                        resultSet.getString(INFO_STATUS)));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }

        return list;
    }
}
